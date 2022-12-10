package com.example.androidhomework.HomeWork1.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.R

class MainScreenViewModel : ViewModel() {

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    fun openDialog() {
        _msg.value = R.string.letcontinue
    }

}