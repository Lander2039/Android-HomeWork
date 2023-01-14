package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.reg.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }

        viewBinding.btnLogin.setOnClickListener {
            if (it != null) {
                if (viewBinding.etTextName.text.toString().isEmpty()) {
                    viewBinding.textInputLayout.setErrorIconDrawable(R.drawable.error)
                    viewBinding.etTextName.error = getString(R.string.LoginIncorrectly)
                } else if (viewBinding.etTextPassword.text.toString().isEmpty()) {
                    viewBinding.textInputLayout2.setErrorIconDrawable(R.drawable.error)
                    viewBinding.etTextName.error =
                        getString(R.string.PasswordEnteredIncorrectly)
                } else
                    viewModel.loginUser(
                        viewBinding.etTextName.text.toString(),
                        viewBinding.etTextPassword.text.toString()
                    )
                viewModel.finishPerformed()
            }
        }


        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }
            viewBinding.btnRegistrationScreen.setOnClickListener {
                viewModel.openRegistration()
            }
        }
    }
