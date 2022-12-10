package com.example.androidhomework.HomeWork1.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.HomeWork1.presentation.Adapter.ArmorAdapter
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_DATE
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_IMAGEVIEW
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_NAME
import com.example.androidhomework.HomeWork1.utils.BundleConstants.SAMURAI_ARMOR_FRAGMENT
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentSamuraiArmorBinding

class SamuraiArmorFragment : Fragment(), ItemsListener {

    private lateinit var armorAdapter: ArmorAdapter
    private val viewModel: ItemsViewModel by viewModels()

    private var _viewBinding: FragmentSamuraiArmorBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentSamuraiArmorBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        armorAdapter = ArmorAdapter(this)
        viewBinding.resView.layoutManager = LinearLayoutManager(context)
        viewBinding.resView.adapter = armorAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listArmor ->
            armorAdapter.submitList(listArmor)
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle!=null) {
                val infoArmorFragment = InfoArmorFragment()
                val bundle = Bundle()
                bundle.putString(KEY_NAME, navBundle.name)
                bundle.putString(KEY_DATE, navBundle.date)
                bundle.putInt(KEY_IMAGEVIEW, navBundle.image)
                infoArmorFragment.arguments = bundle

                parentFragmentManager.beginTransaction()
                    .replace(R.id.activity_container, infoArmorFragment)
                    .addToBackStack(SAMURAI_ARMOR_FRAGMENT)
                    .commit()

                viewModel.userNavigated()
            }
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
}
