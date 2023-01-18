package com.example.androidhomework.HomeWork1.presentation.view.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {


    private var _viewBinding: FragmentRegistrationBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRegistrationBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewBinding.btnRegistration.setOnClickListener {
            if (viewBinding.etTextEmail.text.toString().isEmpty()) {
                viewBinding.etTextEmail.error = getString(R.string.EmailEnteredIncorrectly)
            } else if (viewBinding.etTextEmail.text.toString().indexOf("@") == -1) {
                viewBinding.etTextEmail.error = getString(R.string.invalidEmail)
            } else if (viewBinding.etTextLogin.text.toString().isEmpty()) {
                viewBinding.etTextLogin.error = getString(R.string.LoginIncorrectly)
            } else if (viewBinding.etTextPasswordRegistration.text.toString().isEmpty()) {
                viewBinding.etTextPasswordRegistration.error =
                    getString(R.string.PasswordEnteredIncorrectly)
            } else if (viewBinding.etTextPasswordRegistration2.text.toString().isEmpty()) {
                viewBinding.etTextPasswordRegistration2.error =
                    getString(R.string.PasswordEnteredIncorrectly)
            } else if (viewBinding.etTextPasswordRegistration.text.toString() != viewBinding.etTextPasswordRegistration2.text.toString()) {
                viewBinding.etTextPasswordRegistration.error =
                    getString(R.string.PasswordsDoNotMatch)
            } else
                navigate(R.id.action_registrationFragment_to_homeFragment)
        }
    }
}