package com.example.guru_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class HbdCompleteActivity : AppCompatActivity() {

    //변수 정의
    lateinit var hbdImage: ImageView
    lateinit var hbdImage2: ImageView
    lateinit var nameView: TextView
    lateinit var dateView: TextView
    lateinit var placeView: TextView
    lateinit var prepView: TextView
    lateinit var sayView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd_complete)

        //위젯과 변수 연결
        hbdImage = findViewById(R.id.hbdCom_img)
        hbdImage2 = findViewById(R.id.hbdCom_img2)
        nameView = findViewById(R.id.hbdCom_name)
        dateView = findViewById(R.id.hbdCom_date)
        placeView = findViewById(R.id.hbdCom_place)
        prepView = findViewById(R.id.hbdCom_prep)
        sayView = findViewById(R.id.hbdCom_ps)

        //인텐트 받기
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        //나머지 인텐트 받기
        val namein = intent.getStringExtra("name").toString()
        val datein = intent.getStringExtra("date").toString()
        val placein = intent.getStringExtra("place").toString()
        val prepin = intent.getStringExtra("prep").toString()
        val sayin = intent.getStringExtra("say").toString()

        //날짜 데이터 전처리 예: 년, 월, 일
        val datesplit = datein.split("/")
        val year = datesplit[0]
        val month = datesplit[1]
        val day = datesplit[2]

        //받은 값 보여주기
        hbdImage.setImageBitmap(bitmap)
        hbdImage2.setImageBitmap(bitmap)
        nameView.text = namein
        dateView.text = year + "년 " + month + "월 " + day + "일"
        placeView.text = placein
        prepView.text = prepin
        sayView.text = sayin

    }
}