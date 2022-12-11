package com.example.androidhomework.HomeWork1.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidhomework.HomeWork1.presentation.Armor.ItemsArmor
import com.example.androidhomework.R


class ItemsViewModel : ViewModel() {

    private val _items = MutableLiveData<List<ItemsArmor>>()
    val items: LiveData<List<ItemsArmor>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

    fun getData() {
        val listArmor = listOf<ItemsArmor>(
            ItemsArmor(
                R.drawable.kabuto,
                "Kabuto",
                "Helmet",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.kasudzuri,
                "Kusazuri",
                "Plate skirt",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.suneate,
                "Suneate",
                "Leggings",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.kogake,
                "Kogake",
                "Plate shoes",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.sode,
                "Sode",
                "Shoulder pads",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.kote,
                "Kote",
                "Bracers",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.tehkko,
                "Tekko",
                "Mittens and gloves",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.kuvagata,
                "Kuvagata",
                "Horns",
                R.drawable.change
            ),
            ItemsArmor(
                R.drawable.mengu,
                "Mengu",
                "Mask",
                R.drawable.change
            )
        )
        _items.value = listArmor
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