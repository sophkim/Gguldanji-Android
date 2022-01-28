package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HbdActivity : AppCompatActivity() {

    lateinit var hbd_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd)

        hbd_btn = findViewById(R.id.wedding_btn)

        hbd_btn.setOnClickListener {
            var intent = Intent(this,HbdInfoActivity::class.java)
            startActivity(intent)
        }
    }
}