package com.example.androidhomework.HomeWork1.domain

import com.example.androidhomework.HomeWork1.presentation.Armor.ItemsArmor

interface ItemsRepository {

    fun getDate2(): List<ItemsArmor>
}