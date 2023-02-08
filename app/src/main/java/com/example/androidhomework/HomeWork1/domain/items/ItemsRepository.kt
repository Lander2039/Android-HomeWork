package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    suspend fun getDate()

    suspend fun showData(): Flow<List<ItemsArmor>>

    suspend fun deleteItemByDescription(name: String)

    suspend fun findItemByDescription(searchText: String): ItemsArmor

    suspend fun favClicked(itemsArmor: ItemsArmor)

    suspend fun getFavorites(): Flow<List<FavoritesModel>>

    suspend fun deleteFavItemByDescription(name: String)

    suspend fun favoritesDatabaseUpdate(favorite: Boolean, name: String)

//    suspend fun getHome(homeModel: HomeModel)
//
//    suspend fun getUserHome(): List<HomeModel>

}