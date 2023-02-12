package com.example.androidhomework.HomeWork1.presentation.Adapter.Listener

interface ItemsListener {

    fun onClick()

    fun onElementSelected (name: String, userName: String, nameCompany: String)

    fun onDeleteClicked(name: String)

    fun onFavClicked(name: String)

    fun updateFavorite(favorite: Boolean, name: String)
}