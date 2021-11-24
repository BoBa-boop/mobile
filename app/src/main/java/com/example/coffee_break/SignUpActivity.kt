package com.example.coffee_break

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recadapters.skid_coffee

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(inflater:LayoutInflater,container: ViewGroup, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val root = Inflater.inflate(R.layout.skid_cof,container, false)
        val rec_coffee : RecyclerView = root.findViewById(R.id.linelay)
        rec_coffee.adapter = skid_coffee(,Skid_coffee().list)
    }
}