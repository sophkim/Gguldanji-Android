package com.example.guru_1

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.*

class WeddingInfoActivity : AppCompatActivity() {

    //변수 정의
    val Gallery = 0
    lateinit var imageButton: ImageButton
    lateinit var imageView: ImageView
    lateinit var completeButton: Button
    lateinit var EditText: EditText
    lateinit var brideName: EditText
    lateinit var groomName: EditText
    lateinit var placeEdit: EditText
    lateinit var back:ImageButton
    lateinit var home:ImageButton


    var myCalendar: Calendar = Calendar.getInstance()
    var myDatePicker =
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wedding_info)

        //위젯과 변수 연결
        imageButton = findViewById(R.id.weddingInfo_imgEdit)
        imageView = findViewById(R.id.imageView)
        completeButton = findViewById(R.id.weddingInfo_btn)
        EditText = findViewById(R.id.weddingInfo_dateEdit)
        brideName = findViewById(R.id.weddingInfo_femaleEdit)
        groomName = findViewById(R.id.weddingInfo_maleEdit)
        placeEdit = findViewById(R.id.weddingInfo_placeEdit)
        back = findViewById(R.id.weddingInfo_back)
        home = findViewById(R.id.weddingInfo_home)

        //메인버튼 클릭 이벤트
        home.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        //뒤로가기 버튼 클릭 이벤트
        back.setOnClickListener {
            var intent = Intent(this,WeddingActivity::class.java)
            startActivity(intent)
        }

        //버튼 클릭 이벤트
        imageButton.setOnClickListener{loadImage()}  //이미지를 가져오는 함수 호출

        completeButton.setOnClickListener{

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
                var intent = Intent(this, WeddingCompleteActivity::class.java)
                intent.putExtra("image", byteArray)
                intent.putExtra("brideName", brideName.text.toString())
                intent.putExtra("groomName", groomName.text.toString())
                intent.putExtra("date", EditText.text.toString())
                intent.putExtra("place", placeEdit.text.toString())

                startActivity(intent)

            }
            catch (e: Exception){
                Toast.makeText(this,"이미지를 선택하세요.", Toast.LENGTH_SHORT).show()
            }

        }

        EditText.setOnClickListener{ //날짜 버튼 클릭시, DatePicker를 통한 날짜 지정
            DatePickerDialog(this, myDatePicker, myCalendar.get(Calendar.YEAR),
            myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    //불러온 이미지를 imageView에 보여줌
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Gallery){
            if(resultCode == RESULT_OK){
                imageButton.setBackgroundColor(Color.parseColor("#00B3B3B3")) //이미지 선택되면 버튼 안보이게

                var dataUri = data?.data
                try{
                    var bitmap : Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,dataUri)
                    imageView.setImageBitmap(bitmap)
                }catch (e:Exception){
                    Toast.makeText(this,"$e",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadImage(){   //앨범에서 이미지를 불러오는 함수

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent,"Load Picture"), Gallery)
    }

    private fun updateLabel() { //현재 날짜로 초기 설정함
        val myFormat = "yyyy/MM/dd"  //  예시: 2022/03/09
        val sdf = SimpleDateFormat(myFormat, Locale.KOREA)
        EditText = findViewById(R.id.weddingInfo_dateEdit)
        EditText.setText(sdf.format(myCalendar.getTime()))

    }
}