package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidhomework.R
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnRegistrationScreen = view.findViewById<Button>(R.id.btnRegistrationScreen)

        val editTextName = view.findViewById<EditText>(R.id.etTextName)
        val editTextPassword = view.findViewById<EditText>(R.id.etTextPassword)

        val textInputLayout = view.findViewById<TextInputLayout>(R.id.textInputLayout)
        val textInputLayout2 = view.findViewById<TextInputLayout>(R.id.textInputLayout2)


        btnLogin.setOnClickListener {
            if (editTextName.text.toString().isEmpty()) {
                textInputLayout.setErrorIconDrawable(R.drawable.error)
                editTextName.error = getString(R.string.LoginIncorrectly)
            } else if (editTextPassword.text.toString().isEmpty()) {
                textInputLayout2.setErrorIconDrawable(R.drawable.error)
                editTextName.error = getString(R.string.PasswordEnteredIncorrectly)
            } else
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, MainScreenFragment())
                    .commit()
        }
        btnRegistrationScreen.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, RegistrationFragment())
                .commit()
        }
    }
}