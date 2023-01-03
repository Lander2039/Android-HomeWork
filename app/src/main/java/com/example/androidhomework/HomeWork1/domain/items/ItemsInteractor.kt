package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import javax.inject.Inject

class ItemsInteractor @Inject constructor(private val itemsRepository: ItemsRepository) {

    fun getDate3(): List<ItemsArmor>{
        return  itemsRepository.getDate2()
    }
}