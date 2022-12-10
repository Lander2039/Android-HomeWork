package com.example.androidhomework.HomeWork1.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel:ViewModel() {

private val _radioButtonState = MutableLiveData<RadioButtonState>()
    val radioButtonState: LiveData<RadioButtonState>
    get() = _radioButtonState

    fun changeRadioButtonState(firstChecked:Boolean,secondChecked: Boolean){
        if (firstChecked){
            _radioButtonState.value = RadioButtonState(true,false)
        } else if (secondChecked){
            _radioButtonState.value = RadioButtonState(false,true)
        }
    }
}

data class RadioButtonState(val firstButtonChecked:Boolean, val secondButtonChecked:Boolean)