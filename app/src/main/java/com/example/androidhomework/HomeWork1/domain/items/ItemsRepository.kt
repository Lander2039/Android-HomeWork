package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor

interface ItemsRepository {

    suspend fun getDate()

    suspend fun showData(): List<ItemsArmor>
}