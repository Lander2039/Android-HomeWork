package com.example.androidhomework.HomeWork1.presentation.view.items

import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.R
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getItems() {
        val listItems = itemsInteractor.getDate3()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.imageviewclicked)
    }

    fun elementSelected(name: String, date: String, imageView: Int) {
        itemsView.goToDetails(NavigateWithBundle(name, date, imageView))
    }
}

data class NavigateWithBundle(
    val name: String,
    val date: String,
    val image: Int,
)