package com.example.androidhomework.HomeWork1.data.items

import com.example.androidhomework.HomeWork1.data.Service.ApiService
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.domain.items.ItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ItemsRepository {
    override suspend fun getDate2(): List<ItemsArmor> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let { items ->
                items.map {
                    ItemsArmor(
                        it.id,
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
                }
            } ?: kotlin.run {
                emptyList()
            }
        }
    }
}