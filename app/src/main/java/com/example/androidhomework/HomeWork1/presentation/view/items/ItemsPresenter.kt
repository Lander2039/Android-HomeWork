package com.example.androidhomework.HomeWork1.presentation.view.items

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.R
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getItems() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.IO).launch {
            try {
                val job = launch {
                    val listItems = itemsInteractor.getDate3()
                    itemsView.dataReceived(listItems)
                }
                job.join()
                job.cancel()
            } catch (e: Exception) {
                Log.w("exception","Get Items FAILED")
            }
        }
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.imageviewclicked)
    }

    fun elementSelected(name: String, userName: String, nameCompany: String) {
        itemsView.goToDetails(NavigateWithBundle(name, userName, nameCompany))
    }
}

data class NavigateWithBundle(
    val name: String,
    val userName: String,
    val nameCompany: String,
)