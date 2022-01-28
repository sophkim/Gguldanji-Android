package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HbdActivity : AppCompatActivity() {

    //변수 정의
    lateinit var hbd_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd)

        //위젯과 변수 연결
        hbd_btn = findViewById(R.id.wedding_btn)

        //버튼 클릭 이벤트
        hbd_btn.setOnClickListener {
            var intent = Intent(this,HbdInfoActivity::class.java)
            startActivity(intent)
        }
    }
}