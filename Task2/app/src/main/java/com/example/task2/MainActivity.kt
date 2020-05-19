package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener{
            try {
                val first_num = num1.text.toString().toDouble()
                val second_num = num2.text.toString().toDouble()
                answer.text = (first_num + second_num).toString()
            } catch (e: java.lang.NumberFormatException) {
                showSnackbar("Error! Enter numbers in both fields")
                answer.text = ""
            }
        }

        button_subtr.setOnClickListener{
            try {
                val first_num = num1.text.toString().toDouble()
                val second_num = num2.text.toString().toDouble()
                answer.text = (first_num - second_num).toString()
            } catch (e: java.lang.NumberFormatException) {
                showSnackbar("Error! Enter numbers in both fields")
                answer.text = ""
            }
        }

        button_mult.setOnClickListener{
            try {
                val first_num = num1.text.toString().toDouble()
                val second_num = num2.text.toString().toDouble()
                answer.text = (first_num * second_num).toString()
            } catch (e: java.lang.NumberFormatException) {
                showSnackbar("Error! Enter numbers in both fields")
                answer.text = ""
            }
        }

        button_div.setOnClickListener{
            try {
                val first_num = num1.text.toString().toDouble()
                val second_num = num2.text.toString().toDouble()
                if (second_num == 0.0) {
                    showSnackbar("Error! Division by zero")
                    answer.text = ""
                    return@setOnClickListener
                }
                answer.text = (first_num / second_num).toString()
            } catch (e: java.lang.NumberFormatException) {
                showSnackbar("Error! Enter numbers in both fields")
                answer.text = ""
            }
        }
    }

    private fun showSnackbar(message: String) =
        Snackbar.make(layout, message, Snackbar.LENGTH_LONG).show()
}
