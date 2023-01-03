package com.example.androidhomework.HomeWork1.presentation.view.Armor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.HomeWork1.presentation.view.ItemsViewModel

class ItemsViewModelFactory(private val itemsInteractor: ItemsInteractor):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemsViewModel(itemsInteractor) as T
    }
}