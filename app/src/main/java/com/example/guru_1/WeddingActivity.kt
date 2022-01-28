package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class WeddingActivity : AppCompatActivity() {

    //변수 정의
    lateinit var wedding_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding)

        //위젯과 변수 연결
        wedding_btn = findViewById(R.id.wedding_btn)

        //버튼 클릭 이벤트
        wedding_btn.setOnClickListener {
            var intent = Intent(this, WeddingInfoActivity::class.java)
            startActivity(intent)
        }
    }
}