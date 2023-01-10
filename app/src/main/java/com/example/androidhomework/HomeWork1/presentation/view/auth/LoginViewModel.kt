package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinlesson.domain.auth.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {
    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _reg = MutableLiveData<Unit?>()
    val reg: LiveData<Unit?> = _reg

    private val _msg = MutableLiveData<String?>()
    val msg: LiveData<String?> = _msg

    fun finishButtonClicked() {
        _nav.value = Unit
    }

    fun finishPerformed() {
        _nav.value = null
    }

    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _reg.value = Unit
                }
            } catch (e: Exception) {
                _msg.value = e.message.toString()
                Log.w("exception", "loginUser FAILED")
            }
        }
    }
}
