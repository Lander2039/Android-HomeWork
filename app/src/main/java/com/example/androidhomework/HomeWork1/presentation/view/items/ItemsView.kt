package com.example.androidhomework.HomeWork1.presentation.view.items

import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor

interface ItemsView {

    fun dataReceived(list: List<ItemsArmor>)

    fun imageViewClicked(msg: Int)

    fun goToDetails(navigateWithBundle: NavigateWithBundle)
}