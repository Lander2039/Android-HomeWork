package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getDate() {
        return itemsRepository.getDate()
    }

    suspend fun showData(): Flow<List<ItemsArmor>> {
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
    }

    suspend fun getFavorites(): Flow<List<FavoritesModel>> {
        return itemsRepository.getFavorites()
    }

    suspend fun deleteFavItemByDescription(name: String) {
        itemsRepository.deleteFavItemByDescription(name)
    }

    suspend fun favoritesUpdate(favorite: Boolean, name: String){
        return itemsRepository.favoritesDatabaseUpdate(favorite, name)
    }

//    suspend fun getHome(homeModel: HomeModel) {
//        return itemsRepository.getHome(homeModel)
//    }
//
//    suspend fun getUserHome(): List<HomeModel> {
//        return itemsRepository.getUserHome()
//    }
}