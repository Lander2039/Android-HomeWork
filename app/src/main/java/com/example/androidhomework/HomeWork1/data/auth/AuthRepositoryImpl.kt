package com.example.androidhomework.HomeWork1.data.auth

import com.example.kotlinlesson.data.sharedPreferences.SharedPreferencesHelper
import com.example.kotlinlesson.domain.auth.AuthRepository
import com.example.kotlinlesson.domain.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper) :
    AuthRepository {

    override suspend fun LoginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override suspend fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override suspend fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override suspend fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }
}