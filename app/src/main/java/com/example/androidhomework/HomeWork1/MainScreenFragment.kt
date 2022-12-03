package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.androidhomework.R


class MainScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val imageButtonArmor = view.findViewById<ImageButton>(R.id.imageButton)
        val imageButtonWeapon = view.findViewById<ImageButton>(R.id.imageButton2)


        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle(getString(R.string.Wonderful))
            .setMessage(getString(R.string.Congratulations))
            .setCancelable(false)
            .setPositiveButton("Continue"){dialog, _ ->
                Toast.makeText(requireActivity(),"Let's continue", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
        dialog.show()

        imageButtonArmor.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiArmorFragment())
                .addToBackStack(mainScreen)
                .commit()
        }
        imageButtonWeapon.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiWeaponFragment())
                .addToBackStack(mainScreen)
                .commit()
        }

    }
}