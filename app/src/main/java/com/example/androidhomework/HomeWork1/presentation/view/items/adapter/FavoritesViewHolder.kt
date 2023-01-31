package com.example.androidhomework.HomeWork1.presentation.view.items.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.presentation.view.items.adapter.listener.FavoritesListener
import com.example.androidhomework.databinding.ItemFavoritesBinding

class FavoritesViewHolder(
    private val viewBinding: ItemFavoritesBinding,
    private val favoritesListener: FavoritesListener
) : RecyclerView.ViewHolder(viewBinding.root) {
    fun bind(favItems: FavoritesModel) {
        viewBinding.tvName.text = favItems.name
        viewBinding.tvUserName.text = favItems.username
        viewBinding.tvEmail.text = favItems.email
        viewBinding.tvBs.text = favItems.bs
        viewBinding.tvCatchPhrase.text = favItems.catchPhrase
        viewBinding.tvCity.text = favItems.city
        viewBinding.tvCompanyName.text = favItems.companyName
        viewBinding.tvGeoLat.text = favItems.lat
        viewBinding.tvGeoLng.text = favItems.lng
        viewBinding.tvStreet.text = favItems.street
        viewBinding.tvSuite.text = favItems.suite
        viewBinding.tvWebsite.text = favItems.website
        viewBinding.tvZipcode.text = favItems.zipcode
        viewBinding.tvPhone2.text = favItems.phone


        viewBinding.ivDelete.setOnClickListener {
            favoritesListener.onDeleteClicked(favItems.name)
        }
}


}