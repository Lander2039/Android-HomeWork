package com.example.androidhomework.HomeWork1.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor()  : ViewModel() {

    private val _radioButtonState = MutableLiveData<RadioButtonState>()
    val radioButtonState: LiveData<RadioButtonState>
        get() = _radioButtonState

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun changeRadioButtonState(firstChecked: Boolean, secondChecked: Boolean) {
        if (firstChecked) {
            _radioButtonState.value = RadioButtonState(true, false)
        } else if (secondChecked) {
            _radioButtonState.value = RadioButtonState(false, true)
        }
    }

    fun finishButtonClicked() {
        _nav.value = Unit
    }

    fun finishPerformed() {
        _nav.value = null
    }
}

data class RadioButtonState(val firstButtonChecked: Boolean, val secondButtonChecked: Boolean)