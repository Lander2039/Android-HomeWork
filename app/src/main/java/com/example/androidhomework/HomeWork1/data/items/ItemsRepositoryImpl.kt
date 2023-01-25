package com.example.androidhomework.HomeWork1.data.items

import android.util.Log
import com.example.androidhomework.HomeWork1.data.Service.ApiService
import com.example.androidhomework.HomeWork1.data.database.ItemsEntity
import com.example.androidhomework.HomeWork1.data.database.dao.ItemsDAO
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

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
                            Random.nextInt(),
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
                            it.company.bs)
                        itemsDAO.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsArmor> {
        return withContext(Dispatchers.IO){
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map {
                ItemsArmor(
                    it.id,
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