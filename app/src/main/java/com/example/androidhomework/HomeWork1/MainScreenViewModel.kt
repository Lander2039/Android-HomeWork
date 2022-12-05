package com.example.androidhomework.HomeWork1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val mainScreen = "Main Screen"
const val letContinue = "Let's continue"

class MainScreenViewModel: ViewModel() {

    private val _mains = MutableLiveData<String>()
    val mains: LiveData<String> = _mains

    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg

    fun openFragment(){
        _mains.value = mainScreen
    }

    fun openDialog(){
        _msg.value = letContinue
    }

}