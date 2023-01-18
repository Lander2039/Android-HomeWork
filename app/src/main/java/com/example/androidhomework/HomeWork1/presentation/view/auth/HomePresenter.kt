package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomePresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var homeView: HomeView

    fun setView(homeFragment: HomeFragment) {
        homeView = homeFragment
    }

    fun userCreds() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val userCreds = authInteractor.getUserCreds()
                    homeView.showUserDate(userCreds)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
            }
        }
    }

    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    homeView.userLogout()
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
            }
        }
    }

    fun goToMenu() {
        homeView.goToMenu()
    }
}
