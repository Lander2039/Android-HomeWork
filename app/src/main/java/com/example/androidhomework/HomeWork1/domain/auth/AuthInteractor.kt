package com.example.androidhomework.HomeWork1.domain.auth

import com.example.androidhomework.HomeWork1.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    fun loginUser(userName: String, userPassword: String) {
        authRepository.LoginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    fun logoutUser() {
        authRepository.userLogout()
    }
}