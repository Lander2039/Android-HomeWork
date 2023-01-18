package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        viewBinding.btnLogin.setOnClickListener {
            if (viewBinding.etTextName.text.toString().isEmpty()) {
                viewBinding.textInputLayout.setErrorIconDrawable(R.drawable.error)
                viewBinding.etTextName.error = getString(R.string.LoginIncorrectly)
            } else if (viewBinding.etTextPassword.text.toString().isEmpty()) {
                viewBinding.textInputLayout2.setErrorIconDrawable(R.drawable.error)
                viewBinding.etTextName.error = getString(R.string.PasswordEnteredIncorrectly)
            } else
                loginPresenter.loginUser(
                    viewBinding.etTextName.text.toString(),
                    viewBinding.etTextPassword.text.toString()
                )
        }

        viewBinding.btnRegistrationScreen.setOnClickListener {
            loginPresenter.regUser()
        }
    }

    override fun loginUser() {
        navigate(R.id.action_loginFragment_to_homeFragment)
    }

    override fun regUser() {
        navigate(R.id.action_loginFragment_to_registrationFragment)
    }
}