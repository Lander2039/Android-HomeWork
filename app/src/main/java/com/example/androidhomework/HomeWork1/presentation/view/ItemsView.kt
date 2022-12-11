package com.example.androidhomework.HomeWork1.presentation.view

import com.example.androidhomework.HomeWork1.presentation.Armor.ItemsArmor

interface ItemsView {

    fun dataReceived(list: List<ItemsArmor>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(name: String, date: String, imageView: Int)
}