package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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

        val btnArmor = view.findViewById<Button>(R.id.btnArmor)
        val btnWeapon = view.findViewById<Button>(R.id.btnWeapon)

        val fragmentTransaction = parentFragmentManager.beginTransaction()


        val dialog = AlertDialog.Builder(requireActivity())
            .setTitle("Wonderful!!!")
            .setMessage("Congratulations on your successful registration.")
            .setCancelable(false)
            .setPositiveButton("Continue"){dialog, _ ->
                Toast.makeText(requireActivity(),"Let's continue", Toast.LENGTH_SHORT).show()
                dialog.cancel()
            }
        dialog.show()

        btnArmor.setOnClickListener {
            fragmentTransaction.add(R.id.activity_container2, SamuraiArmorFragment())
            fragmentTransaction.commit()
        }
        btnWeapon.setOnClickListener {
            fragmentTransaction.add(R.id.activity_container2, SamuraiWeaponFragment())
            fragmentTransaction.commit()
        }

    }
}