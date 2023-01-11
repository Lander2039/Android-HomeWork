package com.example.androidhomework.HomeWork1.presentation.view.items

import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        GlobalScope.launch {
            val job = launch {
                authInteractor.logoutUser()
                infoArmorView.userLoggedOut()
            }
            job.join()
        }
    }
}