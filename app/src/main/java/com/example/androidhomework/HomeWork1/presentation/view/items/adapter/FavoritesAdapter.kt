package com.example.androidhomework.HomeWork1.presentation.view.items.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.presentation.view.items.adapter.listener.FavoritesListener
import com.example.androidhomework.databinding.ItemFavoritesBinding

class FavoritesAdapter(
    private var favoritesListener: FavoritesListener
) : RecyclerView.Adapter<FavoritesViewHolder>() {

    private var listFav = mutableListOf<FavoritesModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<FavoritesModel>) {
        this.listFav.clear()
        this.listFav = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val viewBinding =
            ItemFavoritesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesViewHolder(viewBinding, favoritesListener)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listFav[position])
    }

    override fun getItemCount(): Int {
        return listFav.size
    }
}