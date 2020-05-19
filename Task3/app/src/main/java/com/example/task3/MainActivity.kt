package com.example.task3

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        snapshot_button.setOnClickListener{
            if (name_field.text.toString().isNullOrEmpty())
                showSnackbar(resources.getString(R.string.name_hint))
            else
                dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data!!.getExtras()
            val intent = Intent(applicationContext, ImageViewActivity::class.java)
            intent.putExtra("data", extras!!.get("data") as Bitmap)
            intent.putExtra("name", name_field.text.toString())
            startActivity(intent)
        }
    }

    private fun showSnackbar(message: String) =
        Snackbar.make(layout, message, Snackbar.LENGTH_LONG).show()
}
