package com.example.androidhomework.HomeWork1.presentation.view.favorites

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var favoritesView: FavoritesView

    fun setView(context: FavoritesView) {
        favoritesView = context
    }

    fun getFavorites() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            val job = launch {
                try {
                    val favoritesItems = itemsInteractor.getFavorites()
                    favoritesView.getFavorites(favoritesItems)
                } catch (e: Exception) {
                    Log.w("exception", "Get Items FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }
}