package com.example.androidhomework.HomeWork1.presentation.view

import com.example.androidhomework.HomeWork1.domain.ItemsInteractor
import com.example.androidhomework.R
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsView: ItemsView,
                     private val itemsInteractor: ItemsInteractor
) {
    fun getDate(){
        val listItems = itemsInteractor.getDate3()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClicked(){
        itemsView.imageViewClicked(R.string.imageviewclicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int){
        itemsView.goToDetails(name,date,imageView)
    }
}