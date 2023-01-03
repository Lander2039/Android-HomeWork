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

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun openDialog() {
        _msg.value = R.string.letcontinue
    }

    fun finishButtonClicked(){
        _nav.value = Unit
    }

    fun finishPerformed(){
        _nav.value = null
    }

}