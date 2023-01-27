package com.example.androidhomework.HomeWork1.presentation.view.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.domain.model.ItemsArmor
import com.example.androidhomework.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchView {

    @Inject
    lateinit var searchPresenter: SearchPresenter

    private var _viewBinding: FragmentSearchBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentSearchBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.search.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                searchPresenter.findItem(p0 ?: "")
                return false
            }
        })


    }

    override fun findItem(searchText: ItemsArmor) {
        viewBinding.tvName.text = searchText.name
        viewBinding.tvUserName.text = searchText.username
        viewBinding.tvEmail.text = searchText.email
        viewBinding.tvBs.text = searchText.bs
        viewBinding.tvCatchPhrase.text = searchText.catchPhrase
        viewBinding.tvCity.text = searchText.city
        viewBinding.tvCompanyName.text = searchText.companyName
        viewBinding.tvGeoLat.text = searchText.lat
        viewBinding.tvGeoLng.text = searchText.lng
        viewBinding.tvStreet.text = searchText.street
        viewBinding.tvSuite.text = searchText.suite
        viewBinding.tvWebsite.text = searchText.website
        viewBinding.tvZipcode.text = searchText.zipcode
        viewBinding.tvPhone2.text = searchText.phone
    }
}