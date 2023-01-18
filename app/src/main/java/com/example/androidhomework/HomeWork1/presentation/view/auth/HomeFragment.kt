package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.HomeWork1.utils.NavHelper.replaceGraph
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homePresenter.userCreds()

        binding.btnLogout.setOnClickListener {
            homePresenter.logoutUser()
        }

        binding.bntGoToMenu.setOnClickListener {
            homePresenter.goToMenu()
        }
    }

    override fun showUserDate() {
        binding.tvUserCreds.text
    }

    override fun userLogout() {
        navigate(R.id.action_homeFragment_to_loginFragment)
    }

    override fun goToMenu() {
        replaceGraph(R.navigation.main_graph)
    }


}