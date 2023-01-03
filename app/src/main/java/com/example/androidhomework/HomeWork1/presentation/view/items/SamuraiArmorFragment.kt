package com.example.androidhomework.HomeWork1.presentation.view.items

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.HomeWork1.presentation.Adapter.ArmorAdapter
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_DATE
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_IMAGEVIEW
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_NAME
import com.example.androidhomework.HomeWork1.utils.BundleConstants.SAMURAI_ARMOR_FRAGMENT
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentSamuraiArmorBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SamuraiArmorFragment: Fragment(), ItemsListener, ItemsView {

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

        itemsPresenter.getItems()

    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.elementSelected(name, date, imageView)
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
        bundle.putString(KEY_DATE, navigateWithBundle.date)
        bundle.putInt(KEY_IMAGEVIEW, navigateWithBundle.image)
        infoArmorFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, infoArmorFragment)
            .addToBackStack(SAMURAI_ARMOR_FRAGMENT)
            .commit()
    }
}
