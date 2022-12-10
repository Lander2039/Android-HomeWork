package com.example.androidhomework.HomeWork1.data

import com.example.androidhomework.HomeWork1.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.domain.ItemsRepository
import com.example.androidhomework.R

class ItemsRepositoryImpl: ItemsRepository {
    override fun getDate2(): List<ItemsArmor> {
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
        return listArmor
    }
}