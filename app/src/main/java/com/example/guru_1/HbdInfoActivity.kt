package com.example.guru_1

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*


class HbdInfoActivity : AppCompatActivity() {

    //변수 정의
    val Gallery = 0
    lateinit var imageButton: ImageButton
    lateinit var imageView: ImageView
    lateinit var nameEdit: EditText
    lateinit var EditText: EditText
    lateinit var placeEdit: EditText
    lateinit var prepEdit: EditText
    lateinit var sayEdit: EditText
    lateinit var completeButton: Button
    lateinit var back:ImageButton
    lateinit var home:ImageButton

    //날짜 지정하기 위한 변수 설정(년, 월, 일)
    var myCalendar: Calendar = Calendar.getInstance()
    var myDatePicker =
        DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd_info)

        //위젯과 변수 연결
        imageButton = findViewById(R.id.hbdInfo_imgEdit)
        imageView = findViewById(R.id.imageView)
        EditText = findViewById(R.id.hbdInfo_dateEdit)
        nameEdit = findViewById(R.id.hbdInfo_nameEdit)
        placeEdit = findViewById(R.id.hbdInfo_placeEdit)
        prepEdit = findViewById(R.id.hbdInfo_prepEdit)
        sayEdit = findViewById(R.id.hbdInfo_sayEdit)
        completeButton = findViewById(R.id.hbdInfo_btn)
        back = findViewById(R.id.hbdInfo_back)
        home = findViewById(R.id.hbdInfo_home)

        //버튼 클릭 이벤트
        imageButton.setOnClickListener{loadImage()}  //사진 첨부

        completeButton.setOnClickListener{ //완료 버튼

            try {
                //이미지 리사이즈
                val stream = ByteArrayOutputStream()
                val bitmap = (imageView.drawable as BitmapDrawable).bitmap
                val scale = (1024 / bitmap.width.toFloat())
                val image_w = (bitmap.width * scale).toInt()
                val image_h = (bitmap.height * scale).toInt()
                val resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true)
                resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)
                val byteArray: ByteArray = stream.toByteArray()

                //인텐트 전달
                var intent = Intent(this, HbdCompleteActivity::class.java)
                intent.putExtra("image", byteArray)
                intent.putExtra("name", nameEdit.text.toString())
                intent.putExtra("date", EditText.text.toString())
                intent.putExtra("place", placeEdit.text.toString())
                intent.putExtra("prep", prepEdit.text.toString())
                intent.putExtra("say", sayEdit.text.toString())

                startActivity(intent)
            }
            catch (e: Exception){
                Toast.makeText(this, "이미지를 선택하세요.", Toast.LENGTH_SHORT).show()
            }

        }
        EditText.setOnClickListener{ //날짜 버튼 클릭시, DatePicker를 통한 날짜 지정
            DatePickerDialog(this, myDatePicker, myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        //뒤로가기 버튼 클릭 이벤트
        back.setOnClickListener {
            var intent = Intent(this,HbdActivity::class.java)
            startActivity(intent)
        }

        //메인버튼 클릭 이벤트
        home.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    //불러온 이미지를 imageView에 보여줌
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Gallery){
            if(resultCode == RESULT_OK){
                imageButton.setBackgroundColor(Color.parseColor("#00B3B3B3"))  //이미지 선택되면 버튼 안보이게

                var dataUri = data?.data
                try{
                    var bitmap : Bitmap = MediaStore.Images.Media.getBitmap(
                        this.contentResolver,
                        dataUri
                    )
                    imageView.setImageBitmap(bitmap)
                }catch (e: Exception){
                    Toast.makeText(this, "$e", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadImage(){  //앨범에서 이미지를 불러오는 함수

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent, "Load Picture"), Gallery)
    }

    private fun updateLabel() { //현재 날짜로 초기 설정함
        val myFormat = "yyyy/MM/dd"  //  예시: 2022/03/09
        val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
        EditText = findViewById(R.id.hbdInfo_dateEdit)
        EditText.setText(sdf.format(myCalendar.getTime()))

    }


}

