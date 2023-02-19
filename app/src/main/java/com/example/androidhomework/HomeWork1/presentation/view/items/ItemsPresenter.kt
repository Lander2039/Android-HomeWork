package com.example.androidhomework.HomeWork1.presentation.view.items

import android.util.Log
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ItemsPresenter @Inject constructor(private val itemsInteractor: ItemsInteractor) {

    private lateinit var itemsView: ItemsView

    private val compositeDisposable = CompositeDisposable()

    fun setView(context: ItemsView) {
        itemsView = context
    }

    fun getItems() {
        val getData = itemsInteractor.getDate().subscribe({}, {})
        compositeDisposable.add(getData)
        val showData = itemsInteractor.showData().subscribe({
            itemsView.dataReceived(it)
        }, {})
        compositeDisposable.add(showData)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.imageviewclicked)
    }

    fun elementSelected(name: String, userName: String, nameCompany: String) {
        itemsView.goToDetails(NavigateWithBundle(name, userName, nameCompany))
    }

    fun onFavClicked(name: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsInteractor.onFavClicked(name)
                } catch (e: Exception) {
                    Log.w("exception", "onFav FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }

    fun deleteItem(name: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsInteractor.deleteItemByDescription(name)
                } catch (e: Exception) {
                    Log.w("exception", "deleteItems FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }

    fun updateFavorite(favorite: Boolean, name: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(coroutineExceptionHandler + Dispatchers.Main).launch {
            val job = launch {
                try {
                    itemsInteractor.favoritesUpdate(favorite, name)
                } catch (e: Exception) {
                    Log.w("exception", "updateItems FAILED")
                }
            }
            job.join()
            job.cancel()
        }
    }
}


data class NavigateWithBundle(
    val name: String,
    val userName: String,
    val nameCompany: String,
)