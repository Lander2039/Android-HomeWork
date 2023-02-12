package com.example.androidhomework.HomeWork1.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidhomework.HomeWork1.App
import com.example.androidhomework.HomeWork1.domain.model.UserModel
import com.example.androidhomework.HomeWork1.utils.NavHelper.navigate
import com.example.androidhomework.HomeWork1.utils.NavHelper.replaceGraph
import com.example.androidhomework.R
import com.example.androidhomework.databinding.FragmentHomeBinding
import javax.inject.Inject


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

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        homePresenter.setView(this)

        homePresenter.userCreds()

//        homePresenter.homeData()


        binding.btnLogout.setOnClickListener {
            homePresenter.logoutUser()
        }

        binding.bntGoToMenu.setOnClickListener {
            homePresenter.goToMenu()
        }
    }

    override fun showUserDate(userCreds: UserModel) {
        binding.tvUserCreds.text = buildString {
            append(getString(R.string.welcome))
            append(userCreds.userName)
            append(getString(R.string.your_password))
            append(userCreds.userPassword)
        }
    }

    override fun userLogout() {
        navigate(R.id.action_homeFragment_to_loginFragment)
    }

    override fun goToMenu() {
        replaceGraph(R.navigation.main_graph)
    }

//    override fun showHomeDate(homeData: List<HomeModel>) {
//        binding.tvHomeCreds.text = "$homeData"
//    }

}