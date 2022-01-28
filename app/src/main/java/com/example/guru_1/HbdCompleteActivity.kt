package com.example.guru_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HbdCompleteActivity : AppCompatActivity() {

    lateinit var hbdImage: ImageView
    lateinit var hbdImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd_complete)

        hbdImage = findViewById(R.id.hbdCom_img)
        hbdImage2 = findViewById(R.id.hbdCom_img2)


        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        hbdImage.setImageBitmap(bitmap)
        hbdImage2.setImageBitmap(bitmap)
    }
}