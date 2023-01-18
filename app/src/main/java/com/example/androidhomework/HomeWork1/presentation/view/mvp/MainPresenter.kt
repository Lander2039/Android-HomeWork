package com.example.androidhomework.HomeWork1.presentation.view.mvp

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity
    }

    fun checkUserExists() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            try {
                val job = launch {
                    val doesUserExists = authInteractor.checkUserExists()
                    mainView.userExistsResult(doesUserExists)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
            }
        }
    }
}
