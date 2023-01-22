package com.example.androidhomework.HomeWork1.presentation.Adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.R
import com.example.androidhomework.databinding.ItemArmorBinding

class ArmorVIewHolder(
    private val viewBinding: ItemArmorBinding,
    private val itemsListener: ItemsListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsArmor: ItemsArmor) {

        viewBinding.tvName.text = itemsArmor.name
        viewBinding.tvUserName.text = itemsArmor.username
        viewBinding.tvEmail.text = itemsArmor.email
        viewBinding.tvBs.text = itemsArmor.bs
        viewBinding.tvCatchPhrase.text = itemsArmor.catchPhrase
        viewBinding.tvCity.text = itemsArmor.city
        viewBinding.tvCompanyName.text = itemsArmor.companyName
        viewBinding.tvGeoLat.text = itemsArmor.lat
        viewBinding.tvGeoLng.text = itemsArmor.lng
        viewBinding.tvStreet.text = itemsArmor.street
        viewBinding.tvSuite.text = itemsArmor.suite
        viewBinding.tvWebsite.text = itemsArmor.website
        viewBinding.tvZipcode.text = itemsArmor.zipcode
        viewBinding.tvPhone2.text = itemsArmor.phone

        var changeL = true
        viewBinding.ivChange.setOnClickListener {
            if (changeL) {
                viewBinding.ivChange.setBackgroundResource(R.drawable.change)
                changeL = false
            } else {
                viewBinding.ivChange.setBackgroundResource(R.drawable.change2)
                changeL = true
            }

        }
        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsArmor.name,
                itemsArmor.street,
                itemsArmor.companyName
            )
        }
    }
}