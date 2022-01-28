package com.example.guru_1

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class WeddingCompleteActivity : AppCompatActivity() {

    lateinit var weddingImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_complete)

        weddingImage = findViewById(R.id.weddingCom_img)

        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray!!.size)

        weddingImage.setImageBitmap(bitmap)
    }
}