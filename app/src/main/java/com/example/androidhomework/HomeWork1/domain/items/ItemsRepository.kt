package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor

interface ItemsRepository {

    suspend fun getDate()

    suspend fun showData(): List<ItemsArmor>

    suspend fun deleteItemByDescription(name: String)

    suspend fun findItemByDescription(searchText: String): ItemsArmor

    suspend fun favClicked(itemsArmor: ItemsArmor)

    suspend fun getFavorites(): List<FavoritesModel>
}