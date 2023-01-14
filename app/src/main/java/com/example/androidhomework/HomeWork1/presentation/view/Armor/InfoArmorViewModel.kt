package com.example.androidhomework.HomeWork1.presentation.view.Armor

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
class InfoArmorViewModel @Inject constructor(private val authInteractor: AuthInteractor) :
    ViewModel() {

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _msg = MutableLiveData<String?>()
    val msg: LiveData<String?> = _msg

    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    authInteractor.logoutUser()
                    _nav.value = R.navigation.auth_graph
                }
            } catch (e: Exception) {
                _msg.value = e.message.toString()
                Log.w("exception", "LogoutUser FAILED")
            }
        }
    }
}
