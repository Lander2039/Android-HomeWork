package com.example.androidhomework.HomeWork1.presentation.view.auth

import com.example.androidhomework.HomeWork1.domain.model.UserModel

interface HomeView {

    fun showUserDate(userCreds: UserModel)
    fun userLogout()
    fun goToMenu()
}