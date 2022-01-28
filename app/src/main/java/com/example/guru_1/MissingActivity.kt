package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MissingActivity : AppCompatActivity() {

    lateinit var missing_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missing)

        missing_btn = findViewById(R.id.missing_btn)

        missing_btn.setOnClickListener {
            var intent = Intent(this,MissingInfoActivity::class.java)
            startActivity(intent)
        }
    }
}