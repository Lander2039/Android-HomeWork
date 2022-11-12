package com.example.androidhomework.HomeWork1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidhomework.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity3::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
        }
    }
}