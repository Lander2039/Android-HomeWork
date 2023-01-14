package com.example.androidhomework.HomeWork1.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginFragment
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)

        viewModel.checkUserExists()

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController

        viewModel.nav.observe(this) {
            navController.setGraph(it)
        }
    }
}
