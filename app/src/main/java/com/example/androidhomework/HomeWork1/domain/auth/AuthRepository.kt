package com.example.androidhomework.HomeWork1.domain.auth

import com.example.androidhomework.HomeWork1.domain.model.UserModel

interface AuthRepository {

    fun LoginUser(userName: String, userPassword: String)
    fun showUserCreds() : UserModel
    fun doesUserExist(): Boolean
    fun userLogout()
}