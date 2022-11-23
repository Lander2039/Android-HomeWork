package com.example.androidhomework.HomeWork1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidhomework.R
import com.google.android.material.textfield.TextInputLayout

class MainActivity4 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val btnRegistration = findViewById<Button>(R.id.btnRegistration)
        val btn10 = findViewById<Button>(R.id.btn10)
        val editTextEmail = findViewById<EditText>(R.id.etTextEmail)
        val editTextLogin = findViewById<EditText>(R.id.etTextLogin)
        val editTextPassword = findViewById<EditText>(R.id.etTextPasswordRegistration)
        val editTextPassword2 = findViewById<EditText>(R.id.etTextPasswordRegistration2)

        val textInputLayoutEmail = findViewById<TextInputLayout>(R.id.textInputLayoutEmail)
        val textInputLayoutLogin = findViewById<TextInputLayout>(R.id.textInputLayoutLogin)
        val textInputLayoutPassword = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)
        val textInputLayoutPassword2 = findViewById<TextInputLayout>(R.id.textInputLayoutPassword2)

        val rb1 = findViewById<RadioButton>(R.id.rb1)
        val rb2 = findViewById<RadioButton>(R.id.rb2)

        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.Confirm))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                Toast.makeText(this, getString(R.string.loginProgress), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.cancel()
            }
        btn10.setOnClickListener {
            if (editTextEmail.text.toString().isEmpty()) {
                textInputLayoutLogin.setErrorIconDrawable(R.drawable.error)
                editTextEmail.error = getString(R.string.LoginIncorrectly)
            } else if (editTextLogin.text.toString().isEmpty()) {
                textInputLayoutLogin.setErrorIconDrawable(R.drawable.error)
                editTextLogin.error = getString(R.string.LoginIncorrectly)
            } else if (editTextPassword.text.toString().isEmpty()) {
                textInputLayoutPassword.setErrorIconDrawable(R.drawable.error)
                editTextPassword.error = getString(R.string.PasswordEnteredIncorrectly)
            } else if (editTextPassword2.text.toString().isEmpty()) {
                textInputLayoutPassword2.setErrorIconDrawable(R.drawable.error)
                editTextPassword2.error = getString(R.string.PasswordEnteredIncorrectly)
            } else
                dialog.setMessage("Do you want to login with username /${editTextLogin.text}/ and password /${editTextPassword.text}/")
            dialog.show()

        }

        rb1.setOnClickListener {
            if (rb1.isChecked) {
                rb2.isChecked = false
            } else {
                rb1.isChecked = true
            }
        }

        rb2.setOnClickListener {
            if (rb2.isChecked) {
                rb1.isChecked = false
            } else {
                rb2.isChecked = true
            }
        }
    }
}