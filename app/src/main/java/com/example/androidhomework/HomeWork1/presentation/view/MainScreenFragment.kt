package com.example.androidhomework.HomeWork1.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.androidhomework.HomeWork1.utils.BundleConstants.MAIN_SCREEN
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment() {

    private var _viewBinding: FragmentMainScreenBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: MainScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        viewBinding.imageButton.setOnClickListener {
                        parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiArmorFragment())
                .addToBackStack(MAIN_SCREEN)
                .commit()
        }
        viewBinding.imageButton2.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiWeaponFragment())
                .addToBackStack(MAIN_SCREEN)
                .commit()
        }
    }
}