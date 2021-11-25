package com.example.coffee_break

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
    }

    fun reg_out(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}