package com.example.guru_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class HbdCompleteActivity : AppCompatActivity() {

    //변수 정의
    lateinit var hbdImage: ImageView
    lateinit var hbdImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd_complete)

        //위젯과 변수 연결
        hbdImage = findViewById(R.id.hbdCom_img)
        hbdImage2 = findViewById(R.id.hbdCom_img2)

        //인텐트 받기
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        //받은 값 보여주기
        hbdImage.setImageBitmap(bitmap)
        hbdImage2.setImageBitmap(bitmap)
    }
}