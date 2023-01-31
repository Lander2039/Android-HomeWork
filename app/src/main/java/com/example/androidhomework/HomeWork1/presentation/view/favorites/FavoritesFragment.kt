package com.example.androidhomework.HomeWork1.presentation.view.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidhomework.HomeWork1.domain.model.FavoritesModel
import com.example.androidhomework.HomeWork1.presentation.view.items.adapter.FavoritesAdapter
import com.example.androidhomework.HomeWork1.presentation.view.items.adapter.listener.FavoritesListener
import com.example.androidhomework.databinding.FragmentFavoritesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoritesFragment : Fragment(), FavoritesView, FavoritesListener {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var favAdapter: FavoritesAdapter

    @Inject
    lateinit var favoritesPresenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoritesPresenter.setView(this)

        favAdapter = FavoritesAdapter(this)

        binding.resView.layoutManager = LinearLayoutManager(requireContext())
        binding.resView.adapter = favAdapter

        favoritesPresenter.getFavorites()
    }

    override fun getFavorites(List: List<FavoritesModel>) {
        favAdapter.submitList(List)
    }

    override fun deleteItem(name: String) {
        favoritesPresenter.deleteFavItem(name)
    }

    override fun onDeleteClicked(name: String) {
        favoritesPresenter.deleteFavItem(name)
    }
}
