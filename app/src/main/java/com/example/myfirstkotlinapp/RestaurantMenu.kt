package com.example.myfirstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_restaurant_menu.*
import kotlinx.android.synthetic.main.custom_toast.*

class RestaurantMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_menu)
        btnOrder.setOnClickListener {
            val checkedMealRadioButtonId = rgBurgurMeals.checkedRadioButtonId
            val burger = findViewById<RadioButton>(checkedMealRadioButtonId)
            val cheese = cbCheese.isChecked
            val onions = cbOnions.isChecked
            val salad = cbSalad.isChecked
            val totalOrder = "Your order is one " + "${burger.text}"+ (if(cheese)"\n Cheese" else "") +
                    (if(onions)" onions" else "")+
                    (if(salad)" salad" else "")
            tvShowMeal.text = totalOrder


        Toast(this).apply {
            duration = Toast.LENGTH_LONG
            view = layoutInflater.inflate(R.layout.custom_toast, clToastCustoming )
            show()
        }
        }

    }
}