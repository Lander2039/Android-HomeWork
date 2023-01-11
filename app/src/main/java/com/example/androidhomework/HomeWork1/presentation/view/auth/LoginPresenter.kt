package com.example.androidhomework.HomeWork1.presentation.view.auth

import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment) {
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPassword: String) {
        GlobalScope.launch {
            val job = launch {
                authInteractor.loginUser(userName, userPassword)
                loginView.loginUser()
            }
            job.join()
        }
    }

    fun regUser() {
        loginView.regUser()
    }
}