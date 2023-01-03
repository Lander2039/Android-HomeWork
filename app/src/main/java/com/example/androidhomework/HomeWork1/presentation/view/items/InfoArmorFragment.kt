package com.example.androidhomework.HomeWork1.presentation.view.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginFragment
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_DATE
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_IMAGEVIEW
import com.example.androidhomework.HomeWork1.utils.BundleConstants.KEY_NAME
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentInfoArmorBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoArmorFragment : Fragment(), InfoArmorView {

    private var _viewBinding: FragmentInfoArmorBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var infoArmorPresenter: InfoArmorPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentInfoArmorBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoArmorPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            infoArmorPresenter.getArguments(
                safeBundle.getString(KEY_NAME),
                safeBundle.getString(KEY_DATE),
                safeBundle.getInt(KEY_IMAGEVIEW),
            )
        }

        viewBinding.btnLogout.setOnClickListener {
            infoArmorPresenter.logoutUser()
        }
    }

    override fun userLoggedOut() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()
    }

    override fun displayItemDate(name: String, date: String, imageView: Int) {
        viewBinding.detailsName.text = name
        viewBinding.detailsDate.text = date
        viewBinding.detailsImage.setBackgroundResource(imageView)
    }
}