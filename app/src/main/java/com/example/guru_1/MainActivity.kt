package com.example.guru_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //변수 정의
    lateinit var wedding_btn: Button
    lateinit var hbd_btn: Button
    lateinit var missing_btn:Button
    lateinit var design_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //위젯과 변수 연결
        wedding_btn = findViewById(R.id.main_wedding_btn)
        hbd_btn = findViewById(R.id.main_hbd_btn)
        missing_btn = findViewById(R.id.main_missing_btn)
        design_btn = findViewById(R.id.main_my_btn)

        //웨딩을 선택했을 때
        wedding_btn.setOnClickListener{
            var intent = Intent(this, WeddingActivity::class.java)
            startActivity(intent)
        }
        //생일을 선택했을 때
        hbd_btn.setOnClickListener{
            var intent = Intent(this, HbdActivity::class.java)
            startActivity(intent)
        }
        //실종을 선택했을 때
        missing_btn.setOnClickListener{
            var intent = Intent(this, MissingActivity::class.java)
            startActivity(intent)
        }

        //마이디자인을 선택했을 때
        design_btn.setOnClickListener{
            var intent = Intent(this, MyDesignActivity::class.java)
            startActivity(intent)
        }

    }
}