package com.example.androidhomework.HomeWork1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidhomework.HomeWork1.MainActivity2.Companion.startMainActivity2
import com.example.androidhomework.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            startActivity(Intent("com.example.androidhomework.HomeWork1.OPEN_ACTIVITY2"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.go_Activity2) {
            startMainActivity2(
                this,
                getString(R.string.secondLevel),
                getString(R.string.PlayGame),
                getString(R.string.clickedSecondItem)
            )
        }
        if (item.itemId == R.id.close) {
            finishAffinity()
        }
        if (item.itemId == R.id.go_Activity3) {
            startActivity(Intent(this, MainActivity3::class.java))
        }
        if (item.itemId == R.id.go_Activity4) {
            startActivity(Intent(this, MainActivity4::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

}