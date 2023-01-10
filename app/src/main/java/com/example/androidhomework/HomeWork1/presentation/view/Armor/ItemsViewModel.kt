package com.example.androidhomework.HomeWork1.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidhomework.HomeWork1.presentation.view.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.domain.items.ItemsInteractor
import com.example.androidhomework.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val itemsInteractor: ItemsInteractor) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsArmor>>()
    val items: LiveData<List<ItemsArmor>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    private val _exp = MutableLiveData<String?>()
    val exp: LiveData<String?> = _exp

    fun getData() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        viewModelScope.launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                launch {
                    val listArmor = itemsInteractor.getDate3()
                    _items.value = listArmor
                }
            } catch (e: Exception) {
                _exp.value = e.message.toString()
                Log.w("exception", "loginUser FAILED")
            }
        }
    }

    fun imageViewClicked() {
        _msg.value = R.string.imageviewclicked
    }

    fun elementClicked(name: String, date: String, imageView: Int) {
        _bundle.value = NavigateWithBundle(name = name, date = date, image = imageView)
    }

    fun userNavigated(){
        _bundle.value = null
    }
}


data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String
)