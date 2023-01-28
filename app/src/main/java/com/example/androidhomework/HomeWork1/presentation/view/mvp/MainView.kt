package com.example.androidhomework.HomeWork1.presentation.view.mvp

import androidx.navigation.NavDestination

interface MainView {

    fun userExistsResult(userExists: Boolean)
    fun destinationChanged(destination: NavDestination)
}