package com.example.androidhomework.HomeWork1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidhomework.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button2 = findViewById<Button>(R.id.button2)
        val textView1 = findViewById<TextView>(R.id.textView2)
        val textView2 = findViewById<TextView>(R.id.textView5)

        val data: String = intent.getStringExtra(KEY1) ?: getString(R.string.noDate)
        val data2: String = intent.getStringExtra(KEY2) ?: getString(R.string.noDate)
        val titleName = intent.getStringExtra(KEY3) ?: getString(R.string.noDate)

        textView1.text = data
        textView2.text = data2

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = titleName


        button2.setOnClickListener {
            startActivity(
                Intent(this, MainActivity3::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            )
        }
    }

    companion object {

        private const val KEY1 = "First key"
        private const val KEY2 = "Second key"
        private const val KEY3 = "Tree key"

        fun startMainActivity2(
            context: Context,
            string: String,
            string1: String,
            string2: String
        ) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY1, string)
            intent.putExtra(KEY2, string1)
            intent.putExtra(KEY3, string2)
            context.startActivity(intent)
        }
    }
}