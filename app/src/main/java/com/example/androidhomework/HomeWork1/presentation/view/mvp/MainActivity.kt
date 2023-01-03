package com.example.androidhomework.HomeWork1.presentation.view.mvp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.HomeWork1.presentation.view.auth.LoginFragment
import com.example.androidhomework.HomeWork1.presentation.view.home.MainScreenFragment
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private var _binding: ActivityMainBinding? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(_binding!!.root)

        mainPresenter.setView(this)

        mainPresenter.checkUserExists()
    }

    override fun userExistsResult(userExists: Boolean) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(
            R.id.activity_container,
            when (userExists) {
                true -> MainScreenFragment()
                false -> LoginFragment()
            }
        )
        fragmentTransaction.commit()
    }
}
