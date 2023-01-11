package com.example.androidhomework.HomeWork1.domain.auth

import com.example.androidhomework.HomeWork1.domain.model.UserModel

interface AuthRepository {

    suspend fun LoginUser(userName: String, userPassword: String)
    suspend fun showUserCreds() : UserModel
    suspend fun doesUserExist(): Boolean
    suspend fun userLogout()
}