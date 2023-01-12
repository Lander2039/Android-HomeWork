package com.example.androidhomework.HomeWork1.presentation.view.items

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class InfoArmorPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var infoArmorView: InfoArmorView

    fun setView(infoArmorFragment: InfoArmorFragment) {
        infoArmorView = infoArmorFragment
    }

    fun getArguments(name: String?, date: String?, imageView: Int) {
        infoArmorView.displayItemDate(
            when (name.isNullOrEmpty()) {
                true -> "NO DATA"
                false -> name
            },
            when (date.isNullOrEmpty()) {
                true -> "NO DATE"
                false -> date
            },
            imageView
        )
    }

    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    authInteractor.logoutUser()
                    infoArmorView.userLoggedOut()
                }
                job.join()
            } catch (e: Exception) {
            }
        }
    }
}
