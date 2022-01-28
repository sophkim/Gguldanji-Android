package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var wedding_btn: Button
    lateinit var hbd_btn: Button
    lateinit var missing_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wedding_btn = findViewById(R.id.main_wedding_btn)
        hbd_btn = findViewById(R.id.main_hbd_btn)
        missing_btn = findViewById(R.id.main_missing_btn)

        wedding_btn.setOnClickListener{
            var intent = Intent(this, WeddingActivity::class.java)
            startActivity(intent)
        }

        hbd_btn.setOnClickListener{
            var intent = Intent(this, HbdActivity::class.java)
            startActivity(intent)
        }

        missing_btn.setOnClickListener{
            var intent = Intent(this, MissingActivity::class.java)
            startActivity(intent)
        }

    }
}