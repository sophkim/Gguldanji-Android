package com.example.guru_1

import DatabaseHelper
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    val helper = DatabaseHelper(this, "memo", 3)
    val SPLASH_VIEW_TIME : Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        helper.deleteMemo()//켤 때마다 DB초기화

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity ::class.java))
            finish()
        }, SPLASH_VIEW_TIME)
    }
}