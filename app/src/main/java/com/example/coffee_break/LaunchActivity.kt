package com.example.coffee_break

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LaunchActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        val save = sharedPreferences.getBoolean("save",false)
        val timer = object : CountDownTimer(1000,100){
            override fun onTick(p0: Long) {

            }
            override fun onFinish() {
                if(save){
                    val intent = Intent(this@LaunchActivity, menuActivity::class.java)
                    startActivity(intent)
                }
                else{
                    val intent = Intent(this@LaunchActivity, GuideActivity::class.java)
                    startActivity(intent)
                }

            }
        }
            timer.start()
    }
}