package com.example.androidhomework.HomeWork1.presentation.view.mvp

import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var mainView: MainView

    fun setView(mainActivity: MainActivity) {
        mainView = mainActivity
    }

    fun checkUserExists() {
        GlobalScope.launch {
            val job = launch {
                val doesUserExists = authInteractor.checkUserExists()
                mainView.userExistsResult(doesUserExists)
            }
            job.join()
        }
    }
}
