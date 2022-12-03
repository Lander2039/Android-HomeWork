package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.androidhomework.R
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegistration = view.findViewById<Button>(R.id.btnRegistration)

        val editTextEmail = view.findViewById<EditText>(R.id.etTextEmail)
        val editTextLogin = view.findViewById<EditText>(R.id.etTextLogin)
        val editTextPassword = view.findViewById<EditText>(R.id.etTextPasswordRegistration)
        val editTextPassword2 = view.findViewById<EditText>(R.id.etTextPasswordRegistration2)

        val textInputLayoutEmail = view.findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val textInputLayoutLogin = view.findViewById<TextInputLayout>(R.id.textInputLayoutLogin)
        val textInputLayoutPassword = view.findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val textInputLayoutPassword2 = view.findViewById<TextInputLayout>(R.id.textInputLayoutPassword2)

        val rb1 = view.findViewById<RadioButton>(R.id.rb1)
        val rb2 = view.findViewById<RadioButton>(R.id.rb2)

        var textView3 = view.findViewById<TextView>(R.id.textView3)
        var textView4 = view.findViewById<TextView>(R.id.textView4)

        viewModel.radioButtonState.observe(viewLifecycleOwner){
            rb1.isChecked = it.firstButtonChecked
            rb2.isChecked = it.secondButtonChecked
        }

        btnRegistration.setOnClickListener {
            if (editTextEmail.text.toString().isEmpty()) {
                editTextEmail.error = getString(R.string.EmailEnteredIncorrectly)
            } else if (editTextEmail.text.toString().indexOf("@") == -1) {
                editTextEmail.error = getString(R.string.invalidEmail)
            } else if (editTextLogin.text.toString().isEmpty()) {
                editTextLogin.error = getString(R.string.LoginIncorrectly)
            } else if (editTextPassword.text.toString().isEmpty()) {
                editTextPassword.error = getString(R.string.PasswordEnteredIncorrectly)
            } else if (editTextPassword2.text.toString().isEmpty()) {
                editTextPassword2.error = getString(R.string.PasswordEnteredIncorrectly)
            } else if (editTextPassword.text.toString() != editTextPassword2.text.toString()) {
                editTextPassword.error = getString(R.string.PasswordsDoNotMatch)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
        }

        rb1.setOnClickListener {
                viewModel.changeRadioButtonState(true,false)
        }

        rb2.setOnClickListener {
            viewModel.changeRadioButtonState(false,true)
        }
    }
    }