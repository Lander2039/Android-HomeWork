package com.example.androidhomework.HomeWork1.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener {
            if (viewBinding.etTextName.text.toString().isEmpty()) {
                viewBinding.textInputLayout.setErrorIconDrawable(R.drawable.error)
                viewBinding.etTextName.error = getString(R.string.LoginIncorrectly)
            } else if (viewBinding.etTextPassword.text.toString().isEmpty()) {
                viewBinding.textInputLayout2.setErrorIconDrawable(R.drawable.error)
                viewBinding.etTextName.error = getString(R.string.PasswordEnteredIncorrectly)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
        }
        viewBinding.btnRegistrationScreen.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, RegistrationFragment())
                .commit()
        }
    }
}