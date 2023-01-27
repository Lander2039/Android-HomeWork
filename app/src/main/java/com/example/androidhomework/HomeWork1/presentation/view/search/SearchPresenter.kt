package com.example.androidhomework.HomeWork1.presentation.view.search

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var searchView: SearchView

    fun setView(context: SearchView) {
        searchView = context
    }

    fun findItem(searchText: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            val job = launch {
                try {
                    val foundItem = itemsInteractor.findItem(searchText)
                    searchView.findItem(foundItem)
                } catch (e: Exception) {
                    Log.w("exception", "Get Items FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }
}