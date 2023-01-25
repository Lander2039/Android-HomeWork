package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    suspend fun getDate() {
        return itemsRepository.getDate()
    }

    suspend fun showData(): List<ItemsArmor> {
        return itemsRepository.showData()
    }
}