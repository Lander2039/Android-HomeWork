package com.example.androidhomework.HomeWork1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidhomework.R
import com.google.android.material.textfield.TextInputLayout
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val editTextName = findViewById<EditText>(R.id.etTextName)
        val editTextPassword = findViewById<EditText>(R.id.etTextPassword)

        val textInputLayout = findViewById<TextInputLayout>(R.id.textInputLayout)
        val textInputLayout2 = findViewById<TextInputLayout>(R.id.textInputLayout2)

        val textView = findViewById<TextView>(R.id.textView5)

        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.Confirm))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.yes)){ dialog, _ ->
                Toast.makeText(this,getString(R.string.loginProgress), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.no)){ dialog, _ ->
                dialog.cancel()
            }

        btnLogin.setOnClickListener {
            if(editTextName.text.toString().isEmpty()){
                textInputLayout.setErrorIconDrawable(R.drawable.error)
                editTextName.error = getString(R.string.LoginIncorrectly)
            } else  if (editTextPassword.text.toString().isEmpty()){
                textInputLayout2.setErrorIconDrawable(R.drawable.error)
                editTextName.error = getString(R.string.PasswordEnteredIncorrectly)
            }
            else
                dialog.setMessage("Do you want to login with username /${editTextName.text}/ and password /${editTextPassword.text}/")
                dialog.show()
        //textView.text = "${editTextName.text.toString()} ${editTextPassword.text.toString()}"
        }
        }

    }
