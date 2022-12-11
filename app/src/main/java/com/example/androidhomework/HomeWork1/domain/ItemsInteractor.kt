package com.example.androidhomework.HomeWork1.domain

import com.example.androidhomework.HomeWork1.presentation.Armor.ItemsArmor

class ItemsInteractor(private val itemsRepository: ItemsRepository) {

    fun getDate3(): List<ItemsArmor>{
        return  itemsRepository.getDate2()
    }
}