package com.example.coffee_break

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView
import recadapters.skid_coffee


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp : Spinner = findViewById(R.id.spinner_drink)
        val selectItem = sp.selectedItem.toString()
        val drinks_list = resources.getStringArray (R.array.menuDrinks)
//
        val menu_coffee : RecyclerView = findViewById(R.id.rec_main)
        menu_coffee.adapter = skid_coffee(this,Skid_coffee().list)

    }
}