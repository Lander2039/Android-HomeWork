package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.HomeWork1.utils.NavHelper.replaceGraph
import com.example.androidhomework.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.showUserDate()

        binding.bntGoToBoarding.setOnClickListener {
            viewModel.userMainMenu()
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                replaceGraph(it)
            }
        }

        binding.btnLogout.setOnClickListener {
            viewModel.userLogout()
        }

        viewModel.log.observe(viewLifecycleOwner) {
            if (it != null) {
                navigate(it)
            }
        }

        viewModel.userCreds.observe(viewLifecycleOwner) {
            binding.tvUserCreds.text = "${it.userName} \n ${it.userPassword}"
        }
    }
}