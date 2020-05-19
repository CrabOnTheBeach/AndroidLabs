package com.example.task3

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_image_view.*

class ImageViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        name_field.text = intent.getStringExtra("name")
        val image = intent.getParcelableExtra("data") as Bitmap
        image_view.setImageBitmap(image)
    }
}
