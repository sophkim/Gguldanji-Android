package com.example.guru_1

import DatabaseHelper
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.Options
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


class MyDesignActivity : AppCompatActivity() {
    val helper = DatabaseHelper(this, "memo", 3)

    //변수 정의
    lateinit var back:ImageButton
    lateinit var home:ImageButton
    lateinit var image1: ImageView
    lateinit var image2: ImageView
    lateinit var image3: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_design)

        //위젯과 변수 연결
        back = findViewById(R.id.myDesign_back)
        home = findViewById(R.id.myDesign_home)
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)

        //DB에서 Memo객체(no, image) 가져오기
        val memoList = helper.getdata()//mutableList객체 반환
        val image_1 = memoList.get(0).image //map(no, 사진) 가져옴
        val image_2 = memoList.get(1).image
        val image_3 = memoList.get(2).image

        //바이트 어레이 to 비트맵
        val bitmap_1 = image_1?.let { BitmapFactory.decodeByteArray(image_1, 0, it.size) }
        val bitmap_2 = image_2?.let { BitmapFactory.decodeByteArray(image_2, 0, it.size) }
        val bitmap_3 = image_3?.let { BitmapFactory.decodeByteArray(image_3, 0, it.size) }

        //화면에 표시
        image1.setImageBitmap(bitmap_1)
        image2.setImageBitmap(bitmap_2)
        image3.setImageBitmap(bitmap_3)

        //메인버튼 클릭 이벤트
        home.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //뒤로가기 버튼 클릭 이벤트
        back.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}