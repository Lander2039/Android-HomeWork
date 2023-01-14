package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import com.example.androidhomework.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {
    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _reg = MutableLiveData<Int?>()
    val reg: LiveData<Int?> = _reg

    private val _msg = MutableLiveData<String?>()
    val msg: LiveData<String?> = _msg

    private val _fin = MutableLiveData<Int?>()
    val fin: LiveData<Int?> = _fin

    fun openRegistration() {
        _nav.value = R.id.action_loginFragment_to_registrationFragment
    }

    fun finishPerformed() {
        _reg.value = null
    }

    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    authInteractor.loginUser(userName, userPassword)
                    _reg.value = R.id.action_loginFragment_to_homeFragment
                }
            } catch (e: Exception) {
                _msg.value = e.message.toString()
                Log.w("exception", "loginUser FAILED")
            }
        }
    }
}
