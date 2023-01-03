package com.example.androidhomework.HomeWork1.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinlesson.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userLogout = MutableLiveData<Boolean>()
    val userLogout: LiveData<Boolean> = _userLogout

    fun checkUserExists() {
        _userLogout.value = authInteractor.checkUserExists()
    }
}