package com.example.androidhomework.HomeWork1.presentation.view.items

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class InfoArmorPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var infoArmorView: InfoArmorView

    fun setView(infoArmorFragment: InfoArmorFragment) {
        infoArmorView = infoArmorFragment
    }

    fun getArguments(name: String, userName: String, nameCompany: String) {
        infoArmorView.displayItemDate(
            when (name.isEmpty()) {
                true -> "NO DATA"
                false -> name
            },
            when (userName.isEmpty()) {
                true -> "NO DATE"
                false -> userName
            },
            when (nameCompany.isEmpty()) {
                true -> "NO DATE"
                false -> nameCompany
            }
        )
    }

    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.IO).launch {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    infoArmorView.userLoggedOut()
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception", "logout user FAILED")
            }
        }
    }
}
