package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.Adapter.ArmorAdapter
import com.example.androidhomework.HomeWork1.Armor.ItemsArmor
import com.example.androidhomework.HomeWork1.Listener.ItemsListener
import com.example.androidhomework.R

class SamuraiArmorFragment : Fragment(), ItemsListener {

    private lateinit var armorAdapter:ArmorAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_samurai_armor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        

        armorAdapter = ArmorAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.resView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = armorAdapter

        val listArmor = mutableListOf(
            ItemsArmor(R.drawable.kabuto,
            "Kabuto",
            "Helmet",
                R.drawable.change),
            ItemsArmor(R.drawable.kasudzuri,
                "Kusazuri",
                "Plate skirt",
                R.drawable.change),
            ItemsArmor(R.drawable.suneate,
                "Suneate",
                "Leggings",
                R.drawable.change),
            ItemsArmor(R.drawable.kogake,
                "Kogake",
                "Plate shoes",
                R.drawable.change),
            ItemsArmor(R.drawable.sode,
                "Sode",
                "Shoulder pads",
                R.drawable.change),
            ItemsArmor(R.drawable.kote,
                "Kote",
                "Bracers",
                R.drawable.change),
            ItemsArmor(R.drawable.tehkko,
                "Tekko",
                "Mittens and gloves",
                R.drawable.change),
            ItemsArmor(R.drawable.kuvagata,
                "Kuvagata",
                "Horns",
                R.drawable.change),
            ItemsArmor(R.drawable.mengu,
                "Mengu",
                "Mask",
                R.drawable.change),
        )
        armorAdapter.submitList(listArmor)
    }

    override fun onClick() {

    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        val infoArmorFragment = InfoArmorFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageView", imageView)
        infoArmorFragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, infoArmorFragment)
            .addToBackStack("Details")
            .commit()
    }
}
