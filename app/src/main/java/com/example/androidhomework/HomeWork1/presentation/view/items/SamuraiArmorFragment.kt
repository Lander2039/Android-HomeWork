package com.example.androidhomework.HomeWork1.presentation.view.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import com.example.androidhomework.HomeWork1.presentation.Adapter.ArmorAdapter
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_DATE
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_IMAGEVIEW
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_NAME
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigateWithBundle
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentSamuraiArmorBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import javax.inject.Inject


@AndroidEntryPoint
class SamuraiArmorFragment : Fragment(), ItemsListener, ItemsView {

    private lateinit var armorAdapter: ArmorAdapter

    @Inject
    lateinit var itemsPresenter: ItemsPresenter

    private var _viewBinding: FragmentSamuraiArmorBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSamuraiArmorBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)

        armorAdapter = ArmorAdapter(this)
        viewBinding.resView.layoutManager = LinearLayoutManager(context)
        viewBinding.resView.adapter = armorAdapter

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemsPresenter.getItems()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            itemsPresenter.listItems.catch {
                Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
                .collect{ flowList ->
                    flowList.collect{ list ->
                        armorAdapter.submitList(list)
                    }
                }
        }
    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, userName: String, nameCompany: String) {
        itemsPresenter.elementSelected(name, userName, nameCompany)
    }

    override fun onDeleteClicked(name: String) {
        itemsPresenter.deleteItem(name)
    }

    override fun onFavClicked(name: String) {
        itemsPresenter.onFavClicked(name)
    }

    override fun deleteItem(name: String) {
        itemsPresenter.deleteItem(name)
    }

    override fun dataReceived(list: List<ItemsArmor>) {
        armorAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(navigateWithBundle: NavigateWithBundle) {
        val infoArmorFragment = InfoArmorFragment()
        val bundle = Bundle()
        bundle.putString(KEY_NAME, navigateWithBundle.name)
        bundle.putString(KEY_DATE, navigateWithBundle.userName)
        bundle.putString(KEY_IMAGEVIEW, navigateWithBundle.nameCompany)
        infoArmorFragment.arguments = bundle

        navigateWithBundle(R.id.action_samuraiArmorFragment_to_infoArmorFragment, bundle)
    }
}
