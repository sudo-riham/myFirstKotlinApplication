package com.example.myfirstkotlinapp

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnApply.setOnClickListener{
            val intent = Intent (this,RestaurantMenu::class.java)
            startActivity(intent)
            var name = etFirstName.text.toString()
            var lastName = etLastName.text.toString()
            var birthdate = etBirthDate.text.toString()
            var country = etCountry.text.toString()
            Toast.makeText(this, "Hello $name $lastName, you were born in $birthdate in $country", Toast.LENGTH_LONG ).show()
        }

        val customList = listOf("Riham", "Salman", "Abdul Majeed", "Nada", "Ahd")
        val namesAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spMonths.adapter = namesAdapter

        spMonths.onItemSelectedListener = object :AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@MainActivity,"You selected ${parent?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_menu_icons, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.miEvents -> Toast.makeText(this, "Event item", Toast.LENGTH_LONG).show()
            R.id.miMembers -> Toast.makeText(this, "Member item", Toast.LENGTH_LONG).show()
            R.id.miCoreTeam -> Toast.makeText(this, "Team item", Toast.LENGTH_LONG).show()
            R.id.miSettings -> Toast.makeText(this, "Settings item", Toast.LENGTH_LONG).show()
            R.id.miLogOut -> {
                val exitAlertDialog = AlertDialog.Builder(this)
                    .setIcon(R.drawable.leave)
                    .setTitle("Exit")
                    .setCancelable(false)
                    .setMessage("Do you want to exit?")
                    .setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                        finish()
                    }
                    .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                        dialogInterface.cancel()

                    }.create()
                exitAlertDialog.show()
            }
        }
                return true
            }
    var pressTwiceToExit = false
    override fun onBackPressed() {
        if(pressTwiceToExit){
            finish()
            super.onBackPressed()
        }
        pressTwiceToExit = true
        Toast.makeText(this,"Press Twice to Exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            pressTwiceToExit= false
        }, 3000)
    }

    }

