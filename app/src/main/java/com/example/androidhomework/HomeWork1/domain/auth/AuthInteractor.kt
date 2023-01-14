package com.example.androidhomework.HomeWork1.domain.auth


import com.example.androidhomework.HomeWork1.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun loginUser(userName: String, userPassword: String) {
        authRepository.LoginUser(userName, userPassword)
    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend fun checkUserExists(): Boolean {
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser() {
        authRepository.userLogout()
    }
}
