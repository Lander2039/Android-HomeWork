package com.example.androidhomework.HomeWork1.presentation.Adapter.Listener

interface ItemsListener {

    fun onClick()

    fun onElementSelected (name: String, userName: String, nameCompany: String)
}