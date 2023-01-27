package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getDate() {
        return itemsRepository.getDate()
    }

    suspend fun showData(): List<ItemsArmor> {
        return itemsRepository.showData()
    }

    suspend fun deleteItemByDescription(name: String) {
        itemsRepository.deleteItemByDescription(name)
    }

    suspend fun findItem(searchText: String): ItemsArmor {
        return itemsRepository.findItemByDescription(searchText)
    }

    suspend fun onFavClicked(name: String) {
        val foundItem = itemsRepository.findItemByDescription(name)
        itemsRepository.favClicked(foundItem)
        itemsRepository.deleteItemByDescription(name)
    }

    suspend fun getFavorites(): List<FavoritesModel> {
        return itemsRepository.getFavorites()
    }
}