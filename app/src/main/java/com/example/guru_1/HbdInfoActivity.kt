package com.example.guru_1

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import java.io.ByteArrayOutputStream

class HbdInfoActivity : AppCompatActivity() {

    val Gallery = 0
    lateinit var imageButton: ImageButton
    lateinit var imageView: ImageView
    lateinit var completeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hbd_info)

        imageButton = findViewById(R.id.hbdInfo_imgEdit)
        imageView = findViewById(R.id.imageView)
        completeButton = findViewById(R.id.hbdInfo_btn)

        imageButton.setOnClickListener{loadImage()}

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
                //

                var intent = Intent(this, HbdCompleteActivity::class.java)
                intent.putExtra("image", byteArray)
                startActivity(intent)
            }
            catch (e: Exception){
                Toast.makeText(this,"이미지를 선택하세요.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Gallery){
            if(resultCode == RESULT_OK){
                imageButton.setBackgroundColor(Color.parseColor("#00B3B3B3"))
                //button.setVisibility(View.INVISIBLE)

                var dataUri = data?.data
                try{
                    var bitmap : Bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver,dataUri)
                    imageView.setImageBitmap(bitmap)



                }catch (e:Exception){
                    Toast.makeText(this,"$e",Toast.LENGTH_SHORT).show()
                }
            }
            /*
            else{
                Toast.makeText(this,"something wrong",Toast.LENGTH_SHORT).show()
            }
             */
        }
    }

    private fun loadImage(){

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent,"Load Picture"), Gallery)
    }


}

