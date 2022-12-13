package com.example.androidhomework.HomeWork1.presentation.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidhomework.HomeWork1.domain.ItemsInteractor

class ItemsViewModelFactory(private val itemsInteractor: ItemsInteractor):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}