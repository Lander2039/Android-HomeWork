package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    fun getDate(): Completable

    fun showData(): Observable<List<ItemsArmor>>

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