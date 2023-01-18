package com.example.androidhomework.HomeWork1.presentation.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.R

class ArmorVIewHolder(
    private val view: View,
    private val itemsListener: ItemsListener
) : RecyclerView.ViewHolder(view) {

    fun bind(itemsArmor: ItemsArmor) {
        val imageView = view.findViewById<ImageView>(R.id.iv_armor)
        val name = view.findViewById<TextView>(R.id.tv_text)
        val date = view.findViewById<TextView>(R.id.tv_date)
        val change = view.findViewById<ImageView>(R.id.iv_change)

        name.text = itemsArmor.nameArmor
        imageView.setBackgroundResource(itemsArmor.image)
        date.text = itemsArmor.descriptionArmor
        change.setBackgroundResource(itemsArmor.change)

        var changeL = true

        change.setOnClickListener {
            if (changeL) {
                change.setBackgroundResource(R.drawable.change)
                changeL = false
            } else {
                change.setBackgroundResource(R.drawable.change2)
                changeL = true
            }

        }
        itemView.setOnClickListener {
            itemsListener.onElementSelected(
                itemsArmor.nameArmor,
                itemsArmor.descriptionArmor,
                itemsArmor.image
            )
        }
    }
}