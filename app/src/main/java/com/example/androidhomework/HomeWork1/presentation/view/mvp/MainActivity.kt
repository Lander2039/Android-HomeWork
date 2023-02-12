package com.example.androidhomework.HomeWork1.presentation.view.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidhomework.HomeWork1.App
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView, NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainPresenter: MainPresenter

    lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        (applicationContext as App).provideAppComponent().inject(this)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener(this)

        binding.bottonNavigation.setupWithNavController(navController)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()
    }

    override fun userExistsResult(userExists: Boolean) {
        when (userExists) {
            true -> navController.setGraph(R.navigation.main_graph)
            false -> navController.setGraph(R.navigation.auth_graph)
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        mainPresenter.destinationChanged(destination)
    }

    override fun destinationChanged(destination: NavDestination) {
        if (destination.id == R.id.loginFragment || destination.id == R.id.homeFragment || destination.id == R.id.registrationFragment) {
            binding.bottonNavigation.visibility = View.GONE
        } else {
            binding.bottonNavigation.visibility = View.VISIBLE
        }
    }
}
