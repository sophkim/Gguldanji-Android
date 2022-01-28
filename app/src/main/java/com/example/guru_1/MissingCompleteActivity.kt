package com.example.guru_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MissingCompleteActivity : AppCompatActivity() {

    //변수 정의
    lateinit var missingImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missing_complete)

        //위젯과 변수 연결
        missingImage = findViewById(R.id.missingCom_img)

        //인텐트 받기
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        //받은 값 보여주기
        missingImage.setImageBitmap(bitmap)
    }
}