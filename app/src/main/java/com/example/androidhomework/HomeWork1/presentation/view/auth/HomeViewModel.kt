package com.example.androidhomework.HomeWork1.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.HomeWork1.domain.auth.AuthInteractor
import com.example.androidhomework.HomeWork1.domain.model.UserModel
import com.example.androidhomework.R

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    private val _log = MutableLiveData<Int?>()
    val log: LiveData<Int?> = _log

    fun showUserDate() {
        viewModelScope.launch {
            _userCreds.value = authInteractor.getUserCreds()
        }
    }

    fun userMainMenu() {
        _nav.value = R.navigation.main_graph
    }

    fun userLogout() {
        viewModelScope.launch {
            authInteractor.logoutUser()
            _log.value = R.navigation.auth_graph
        }
    }
}

data class NavToItems(
    val destinationId: Int,
    val removeFragmentId: Int
)