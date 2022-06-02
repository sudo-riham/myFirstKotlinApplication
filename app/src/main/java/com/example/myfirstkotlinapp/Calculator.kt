package com.example.myfirstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*
class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        btnAdd.setOnClickListener {
            val a = etFirstNumber.text.toString().toInt()
            val b = etSecondNumber.text.toString().toInt()
            var result = a + b
            tvResult.text = result.toString()


        }
        btnMultiply.setOnClickListener {
            val a = etFirstNumber.text.toString().toInt()
            val b = etSecondNumber.text.toString().toInt()
            var result = a * b
            tvResult.text = result.toString()
        }
        btnSubtract.setOnClickListener {
            val a = etFirstNumber.text.toString().toInt()
            val b = etSecondNumber.text.toString().toInt()
            var result = a - b
            tvResult.text = result.toString()
        }
        btnDivide.setOnClickListener {
            val a = etFirstNumber.text.toString().toInt()
            val b = etSecondNumber.text.toString().toInt()
            var result = a / b
            tvResult.text = result.toString()
        }

    }
}