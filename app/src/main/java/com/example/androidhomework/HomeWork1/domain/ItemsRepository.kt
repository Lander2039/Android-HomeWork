package com.example.androidhomework.HomeWork1.domain

import com.example.androidhomework.HomeWork1.Armor.ItemsArmor

interface ItemsRepository {

    fun getDate2(): List<ItemsArmor>
}