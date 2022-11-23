package com.example.androidhomework.HomeWork1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androidhomework.R

class MainActivity5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val car = CarBuilder.Builder
            .setengineVolume(3)
            .setFourWheelDrive(true)
            .setsecuritySystems(5)
            .build()

    }
}