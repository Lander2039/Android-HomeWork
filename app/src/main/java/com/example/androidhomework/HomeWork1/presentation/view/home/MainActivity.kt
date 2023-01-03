package com.example.androidhomework.HomeWork1.presentation.view.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginFragment
import com.example.androidhomework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.checkUserExists()



        viewModel.userLogout.observe(this) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.activity_container,
                    when (it) {
                        true -> MainScreenFragment()
                        false -> LoginFragment()
                    }
                )
                fragmentTransaction.commit()
        }
    }
}
