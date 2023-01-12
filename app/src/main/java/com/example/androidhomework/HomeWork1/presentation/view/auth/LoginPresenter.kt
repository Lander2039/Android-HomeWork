package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var loginView: LoginView

    fun setView(loginFragment: LoginFragment) {
        loginView = loginFragment
    }

    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
            val job = launch {
                authInteractor.loginUser(userName, userPassword)
                loginView.loginUser()
            }
            job.join()
        } catch (e: Exception){
        }
        }
    }

    fun regUser() {
        loginView.regUser()
    }
}
