package com.example.androidhomework.HomeWork1.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidhomework.R

object FragmentNavigation {

    fun moveFragment (parentFragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean){
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .addToBackStack("")
                .commit()
        } else{
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)

                .commit()
        }
    }
}