package com.example.androidhomework.HomeWork1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidhomework.R
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener {
            startActivity(
                Intent(this, MainActivity4::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }

    override fun onBackPressed() {
        finishAffinity();
    }
}