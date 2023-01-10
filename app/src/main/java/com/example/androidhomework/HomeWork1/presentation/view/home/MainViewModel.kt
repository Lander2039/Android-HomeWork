package com.example.androidhomework.HomeWork1.presentation.view.home

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
class MainViewModel @Inject constructor(
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _userLogout = MutableLiveData<Boolean>()
    val userLogout: LiveData<Boolean> = _userLogout

    private val _msg = MutableLiveData<String?>()
    val msg: LiveData<String?> = _msg

    fun checkUserExists() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    _userLogout.value = authInteractor.checkUserExists()
                }
            } catch (e: Exception) {
                _msg.value = e.message.toString()
                Log.w("exception", "CheckUserExists FAILED")
            }
        }
    }
}
