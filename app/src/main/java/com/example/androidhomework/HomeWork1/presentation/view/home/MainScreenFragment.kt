package com.example.androidhomework.HomeWork1.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.androidhomework.HomeWork1.presentation.view.Armor.SamuraiArmorFragment
import com.example.androidhomework.HomeWork1.presentation.view.Armor.SamuraiWeaponFragment
import com.example.androidhomework.HomeWork1.utils.FragmentNavigation
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentMainScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private var _viewBinding: FragmentMainScreenBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMainScreenBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openDialog()
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
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

        viewModel.finishButtonClicked()

        viewModel.nav.observe(viewLifecycleOwner) {
            viewBinding.imageButton.setOnClickListener {
                if (it != null) {
                    FragmentNavigation.moveFragment(
                        parentFragmentManager,
                        SamuraiArmorFragment(),
                        true
                    )
                }
                viewModel.finishPerformed()
            }
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            viewBinding.imageButton2.setOnClickListener {
                if (it != null) {
                    FragmentNavigation.moveFragment(
                        parentFragmentManager,
                        SamuraiWeaponFragment(),
                        true
                    )
                }
                viewModel.finishPerformed()
            }
        }
    }
}