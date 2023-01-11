package com.example.androidhomework.HomeWork1.data.auth

import com.example.androidhomework.HomeWork1.data.sharedPreferences.SharedPreferencesHelper
import com.example.androidhomework.HomeWork1.domain.auth.AuthRepository
import com.example.androidhomework.HomeWork1.domain.model.UserModel
import javax.inject.Inject

class AuthRepositiryImpl @Inject constructor(private val sharedPreferencesHelper: SharedPreferencesHelper):AuthRepository {

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