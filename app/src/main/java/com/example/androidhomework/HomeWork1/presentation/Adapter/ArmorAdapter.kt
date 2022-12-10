package com.example.androidhomework.HomeWork1.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.R

class ArmorAdapter(
    private val itemsListener: ItemsListener
): RecyclerView.Adapter<ArmorVIewHolder>(){

    private var listArmor = listOf<ItemsArmor>()

    fun submitList (list: List<ItemsArmor>){
        this.listArmor = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmorVIewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_armor,parent,false)
    return ArmorVIewHolder(view, itemsListener)
    }

    override fun onBindViewHolder(holder: ArmorVIewHolder, position: Int) {
        holder.bind(listArmor[position])
    }

    override fun getItemCount(): Int {
        return listArmor.size
    }
}
