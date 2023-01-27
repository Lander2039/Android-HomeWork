package com.example.androidhomework.HomeWork1.data.items

import android.util.Log
import com.example.androidhomework.HomeWork1.data.Service.ApiService
import com.example.androidhomework.HomeWork1.data.database.FavoritesEntity
import com.example.androidhomework.HomeWork1.data.database.ItemsEntity
import com.example.androidhomework.HomeWork1.data.database.dao.ItemsDAO
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO
) : ItemsRepository {


    override suspend fun getDate() {
        return withContext(Dispatchers.IO) {
            if (!itemsDAO.doesItemsEntityExist()) {
                Log.w("getData", "data not exists")
                val response = apiService.getData()

                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(
                            Random().nextInt(),
                            it.name,
                            it.username,
                            it.email,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.address.geo.lat,
                            it.address.geo.lng,
                            it.phone,
                            it.website,
                            it.company.name,
                            it.company.catchPhrase,
                            it.company.bs
                        )
                        itemsDAO.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsArmor> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map {
                ItemsArmor(
                    Random().nextInt(),
                    it.name,
                    it.username,
                    it.email,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.phone,
                    it.website,
                    it.companyName,
                    it.catchPhrase,
                    it.bs
                )
            }
        }
    }

    override suspend fun deleteItemByDescription(name: String) {
        withContext(Dispatchers.IO) {
            itemsDAO.deleteItemEntityByDescription(name)
        }
    }

    override suspend fun findItemByDescription(searchText: String): ItemsArmor {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.findItemEntityByDescription(searchText)
            ItemsArmor(
                Random().nextInt(),
                itemsEntity.name,
                itemsEntity.username,
                itemsEntity.email,
                itemsEntity.street,
                itemsEntity.suite,
                itemsEntity.city,
                itemsEntity.zipcode,
                itemsEntity.lat,
                itemsEntity.lng,
                itemsEntity.phone,
                itemsEntity.website,
                itemsEntity.companyName,
                itemsEntity.catchPhrase,
                itemsEntity.bs
            )
        }
    }

    override suspend fun favClicked(itemsArmor: ItemsArmor) {
        return withContext(Dispatchers.IO) {
            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(
                    Random().nextInt(),
                    itemsArmor.name,
                    itemsArmor.username,
                    itemsArmor.email,
                    itemsArmor.street,
                    itemsArmor.suite,
                    itemsArmor.city,
                    itemsArmor.zipcode,
                    itemsArmor.lat,
                    itemsArmor.lng,
                    itemsArmor.phone,
                    itemsArmor.website,
                    itemsArmor.companyName,
                    itemsArmor.catchPhrase,
                    itemsArmor.bs
                )
            )
        }
    }

    override suspend fun getFavorites(): List<FavoritesModel> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = itemsDAO.getFavoritesEntity()
            favoritesEntity.map {
                FavoritesModel(
                    Random().nextInt(),
                    it.name,
                    it.username,
                    it.email,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.phone,
                    it.website,
                    it.companyName,
                    it.catchPhrase,
                    it.bs
                )
            }
        }
    }
}