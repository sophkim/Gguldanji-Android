package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class WeddingActivity : AppCompatActivity() {

    //변수 정의
    lateinit var wedding_btn:Button
    lateinit var back: ImageButton
    lateinit var home: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding)

        //위젯과 변수 연결
        wedding_btn = findViewById(R.id.wedding_btn)
        back = findViewById(R.id.wedding_back)
        home = findViewById(R.id.wedding_home)

        //버튼 클릭 이벤트
        wedding_btn.setOnClickListener {
            var intent = Intent(this, WeddingInfoActivity::class.java)
            startActivity(intent)
        }

        //메인버튼 클릭 이벤트
        home.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //뒤로가기 버튼 클릭 이벤트
        back.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}