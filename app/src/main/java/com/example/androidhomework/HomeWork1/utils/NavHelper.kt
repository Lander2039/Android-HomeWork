package com.example.androidhomework.HomeWork1.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object NavHelper {

    fun Fragment.navigate(destinationId: Int) {
        findNavController().navigate(destinationId)
    }

    fun Fragment.replaceGraph(graphId: Int) {
        findNavController().setGraph(graphId)
    }


    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle) {
        findNavController().navigate(destinationId, bundle)
    }
}