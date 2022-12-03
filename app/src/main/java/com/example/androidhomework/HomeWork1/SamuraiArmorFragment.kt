package com.example.androidhomework.HomeWork1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidhomework.HomeWork1.Adapter.ArmorAdapter
import com.example.androidhomework.HomeWork1.Listener.ItemsListener
import com.example.androidhomework.R

class SamuraiArmorFragment : Fragment(), ItemsListener {

    private lateinit var armorAdapter: ArmorAdapter
    private val viewModel: ItemsViewModel by viewModels()

//    private val keyName: String = "name"
//    private val keyDate: String = "date"
//    private val keyImageView: String = "imageView"

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

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listArmor ->
            armorAdapter.submitList(listArmor)
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            val infoArmorFragment = InfoArmorFragment()
            val bundle = Bundle()
            bundle.putString(keyName, navBundle.name)
            bundle.putString(keyDate, navBundle.date)
            bundle.putInt(keyImageView, navBundle.image)
            infoArmorFragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, infoArmorFragment)
                .addToBackStack(samuraiArmorFragment)
                .commit()
        }
    }

    override fun onClick() {
        viewModel.imageViewClicked()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }
}
