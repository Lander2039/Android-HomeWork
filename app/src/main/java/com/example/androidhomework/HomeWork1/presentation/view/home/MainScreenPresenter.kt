package com.example.androidhomework.HomeWork1.presentation.view.home

import com.example.androidhomework.R
import javax.inject.Inject

class MainScreenPresenter @Inject constructor() {
    private lateinit var mainScreenView: MainScreenView

    fun setView (mainScreenFragment: MainScreenFragment){
        mainScreenView = mainScreenFragment
    }

    fun goToArmorFragment(){
        mainScreenView.goToArmorFragment()
    }

    fun goToWeaponFragment(){
        mainScreenView.goToWeaponFragment()
    }

    fun startDialog(){
        mainScreenView.startDialog(R.string.letcontinue)
    }
}