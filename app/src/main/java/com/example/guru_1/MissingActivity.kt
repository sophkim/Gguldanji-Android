package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MissingActivity : AppCompatActivity() {

    //변수 정의
    lateinit var missing_btn:Button
    lateinit var back: ImageButton
    lateinit var home: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missing)

        //위젯과 변수 연결
        missing_btn = findViewById(R.id.missing_btn)
        back = findViewById(R.id.missing_back)
        home = findViewById(R.id.missing_home)

        //버튼 클릭 이벤트
        missing_btn.setOnClickListener {
            var intent = Intent(this,MissingInfoActivity::class.java)
            startActivity(intent)
        }

        //뒤로가기 클릭 이벤트
        back.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //메인 버튼 클릭 이벤트
        home.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}