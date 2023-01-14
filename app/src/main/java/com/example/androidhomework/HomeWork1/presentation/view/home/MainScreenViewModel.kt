package com.example.androidhomework.HomeWork1.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor() : ViewModel() {

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _arm = MutableLiveData<Int?>()
    val arm: LiveData<Int?> = _arm

    fun openDialog() {
        _msg.value = R.string.letcontinue
    }

    fun openArmor(){
        _nav.value = R.id.action_mainScreenFragment_to_samuraiArmorFragment
    }

    fun finishPerformed(){
        _nav.value = null
    }

    fun openWeapon(){
        _arm.value = R.id.action_mainScreenFragment_to_samuraiWeaponFragment
    }

}