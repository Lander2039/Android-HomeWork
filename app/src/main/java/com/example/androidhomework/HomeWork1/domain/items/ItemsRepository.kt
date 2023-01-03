package com.example.androidhomework.HomeWork1.domain.items

import com.example.androidhomework.HomeWork1.presentation.view.Armor.ItemsArmor

interface ItemsRepository {

    fun getDate2(): List<ItemsArmor>
}