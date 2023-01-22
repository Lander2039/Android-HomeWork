package com.example.androidhomework.HomeWork1.presentation.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.domain.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.presentation.Adapter.Listener.ItemsListener
import com.example.androidhomework.databinding.ItemArmorBinding

class ArmorAdapter(
    private val itemsListener: ItemsListener
) : RecyclerView.Adapter<ArmorVIewHolder>() {

    private var listArmor = mutableListOf<ItemsArmor>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ItemsArmor>) {
        this.listArmor.clear()
        this.listArmor = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArmorVIewHolder {
        val viewBinding =
            ItemArmorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArmorVIewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ArmorVIewHolder, position: Int) {
        holder.bind(listArmor[position])
    }

    override fun getItemCount(): Int {
        return listArmor.size
    }
}

