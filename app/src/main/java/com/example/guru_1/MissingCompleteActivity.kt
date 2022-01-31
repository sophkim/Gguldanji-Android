package com.example.guru_1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MissingCompleteActivity : AppCompatActivity() {

    //변수 정의
    lateinit var missingImage: ImageView
    lateinit var missingInfo: TextView
    lateinit var missingDate: TextView
    lateinit var missingPlace: TextView
    lateinit var missingFeat: TextView
    lateinit var missingPhone: TextView
    lateinit var missingSay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_missing_complete)

        //위젯과 변수 연결
        missingImage = findViewById(R.id.missingCom_img)
        missingInfo = findViewById(R.id.missingCom_info)
        missingDate = findViewById(R.id.missingCom_date)
        missingPlace = findViewById(R.id.missingCom_place)
        missingFeat = findViewById(R.id.missingCom_tx3)
        missingPhone = findViewById(R.id.missingCom_phone)
        missingSay = findViewById(R.id.missingCom_say)

        //인텐트 받기
        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)

        val namein = intent.getStringExtra("name").toString()
        val agein = intent.getStringExtra("age").toString()
        val genderin = intent.getStringExtra("gender").toString()
        val featin = intent.getStringExtra("feature").toString()
        val datein = intent.getStringExtra("date").toString()
        val placein = intent.getStringExtra("place").toString()
        val numin = intent.getStringExtra("num").toString()
        val sayin = intent.getStringExtra("say").toString()

        //날짜 데이터 전처리 예: 년, 월, 일
        val datesplit = datein.split("/")
        val year = datesplit[0]
        val month = datesplit[1]
        val day = datesplit[2]

        //받은 값 보여주기
        missingImage.setImageBitmap(bitmap)
        missingInfo.text = namein + "/" + agein + "/" + genderin
        missingDate.text = year + "년 " + month + "월 " + day + "일"
        missingPlace.text = placein
        missingFeat.text = featin
        missingPhone.text = numin
        missingSay.text = sayin
    }
}