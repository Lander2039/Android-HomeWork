package com.example.androidhomework.HomeWork1.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _reg = MutableLiveData<Unit?>()
    val reg: LiveData<Unit?> = _reg

    fun finishButtonClicked() {
        _nav.value = Unit
    }

    fun finishPerformed() {
        _nav.value = null
    }

    fun loginUser(userName: String, userPassword: String){
        authInteractor.loginUser(userName, userPassword)
        _reg.value = Unit
    }
}