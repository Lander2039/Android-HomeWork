package com.example.androidhomework.HomeWork1.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.presentation.view.items.SamuraiWeaponFragment
import com.example.androidhomework.HomeWork1.presentation.view.items.SamuraiArmorFragment
import com.example.androidhomework.HomeWork1.utils.BundleConstants.MAIN_SCREEN
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainScreenFragment : Fragment(), MainScreenView {

    private var _viewBinding: FragmentMainScreenBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var mainScreenPresenter: MainScreenPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMainScreenBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainScreenPresenter.setView(this)

        mainScreenPresenter.startDialog()

        viewBinding.btnArmor.setOnClickListener {
            mainScreenPresenter.goToArmorFragment()
        }
        viewBinding.btnWeapon.setOnClickListener {
            mainScreenPresenter.goToWeaponFragment()
        }
    }

    override fun goToArmorFragment() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, SamuraiArmorFragment())
            .addToBackStack(MAIN_SCREEN)
            .commit()
    }

    override fun goToWeaponFragment() {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, SamuraiWeaponFragment())
            .addToBackStack(MAIN_SCREEN)
            .commit()
    }

    override fun startDialog(msg: Int) {
        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.Wonderful))
            .setMessage(getString(R.string.Congratulations))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.continueDialog)) { dialog, _ ->
                Toast.makeText(requireActivity(), getString(msg), Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
        dialog.show()
    }
}