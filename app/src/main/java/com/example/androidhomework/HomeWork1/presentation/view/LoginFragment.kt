package com.example.androidhomework.HomeWork1.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.finishButtonClicked()
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                viewBinding.btnLogin.setOnClickListener {
                    if (viewBinding.etTextName.text.toString().isEmpty()) {
                        viewBinding.textInputLayout.setErrorIconDrawable(R.drawable.error)
                        viewBinding.etTextName.error = getString(R.string.LoginIncorrectly)
                    } else if (viewBinding.etTextPassword.text.toString().isEmpty()) {
                        viewBinding.textInputLayout2.setErrorIconDrawable(R.drawable.error)
                        viewBinding.etTextName.error =
                            getString(R.string.PasswordEnteredIncorrectly)
                    } else
                        FragmentNavigation.moveFragment(
                            parentFragmentManager,
                            MainScreenFragment(),
                            false
                        )
                }
                viewModel.finishPerformed()
            }
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            viewBinding.btnRegistrationScreen.setOnClickListener {
                if (it != null) {
                    FragmentNavigation.moveFragment(
                        parentFragmentManager,
                        RegistrationFragment(),
                        true
                    )
                    viewModel.finishPerformed()
                }
            }
        }
    }
}