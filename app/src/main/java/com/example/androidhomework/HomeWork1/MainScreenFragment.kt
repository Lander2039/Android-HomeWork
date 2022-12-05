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
import androidx.fragment.app.viewModels
import com.example.androidhomework.R


class MainScreenFragment : Fragment() {

    private val viewModel: MainScreenViewModel by viewModels()

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


        viewModel.openDialog()
        viewModel.msg.observe(viewLifecycleOwner){msg->
            val dialog = AlertDialog.Builder(requireActivity())
                .setTitle(getString(R.string.Wonderful))
                .setMessage(getString(R.string.Congratulations))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.continueDialog)){ dialog, _ ->
                    Toast.makeText(requireActivity(),msg, Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                }
            dialog.show()
        }

        viewModel.mains.observe(viewLifecycleOwner){ maims ->
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiArmorFragment())
                .addToBackStack(maims)
                .commit()
        }

        viewModel.mains.observe(viewLifecycleOwner){ mains ->
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, SamuraiWeaponFragment())
                .addToBackStack(mains)
                .commit()
        }

        imageButtonArmor.setOnClickListener {
            viewModel.openFragment()
        }
        imageButtonWeapon.setOnClickListener {
            viewModel.openFragment()
        }

    }
}