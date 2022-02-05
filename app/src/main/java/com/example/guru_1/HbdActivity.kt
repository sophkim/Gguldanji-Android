package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class HbdActivity : AppCompatActivity() {

    //변수 정의
    lateinit var hbd_btn: Button
    lateinit var back:ImageButton
    lateinit var home:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd)

        //위젯과 변수 연결
        hbd_btn = findViewById(R.id.wedding_btn)
        back = findViewById(R.id.hbd_back)
        home = findViewById(R.id.hbd_home)

        //버튼 클릭 이벤트
        hbd_btn.setOnClickListener {
            var intent = Intent(this,HbdInfoActivity::class.java)
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