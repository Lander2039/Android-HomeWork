package com.example.androidhomework.HomeWork1.presentation.view

import android.annotation.SuppressLint

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.androidhomework.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.activity_container, LoginFragment())
        fragmentTransaction.commit()

    }
}
