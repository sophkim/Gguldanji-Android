package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WeddingActivity : AppCompatActivity() {

    lateinit var wedding_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding)

        wedding_btn = findViewById(R.id.wedding_btn)

        wedding_btn.setOnClickListener {
            var intent = Intent(this, WeddingInfoActivity::class.java)
            startActivity(intent)
        }
    }
}