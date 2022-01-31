package com.example.guru_1

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class WeddingCompleteActivity : AppCompatActivity() {

    //변수 정의
    lateinit var weddingImage: ImageView
    lateinit var date: TextView
    lateinit var brideName: TextView
    lateinit var groomName: TextView
    lateinit var place: TextView
    lateinit var bigDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_complete)

        //위젯과 변수 연결
        weddingImage = findViewById(R.id.weddingCom_img)
        date = findViewById(R.id.weddingCom_date)
        brideName = findViewById(R.id.weddingCom_name)
        groomName = findViewById(R.id.weddingCom_name2)
        place = findViewById(R.id.weddingCom_place)
        bigDate = findViewById(R.id.weddingCom_bigDate)

        //사진 인텐트 받기
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray!!.size)

        //나머지 인텐트 받기
        val brideNamein = intent.getStringExtra("brideName").toString()
        val groomNamein = intent.getStringExtra("groomName").toString()
        val datein = intent.getStringExtra("date").toString()
        val placein = intent.getStringExtra("place").toString()

        //날짜 데이터 전처리 예: 년, 월, 일
        val datesplit = datein.split("/")
        val year = datesplit[0]
        val month = datesplit[1]
        val day = datesplit[2]

        //받은 값 보여주기
        weddingImage.setImageBitmap(bitmap)
        brideName.text = brideNamein
        groomName.text = groomNamein
        date.text = year + "년 " + month + "월 " + day + "일"
        place.text = placein
        bigDate.text = month + "/" + day

    }
}