package com.example.practich

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlin.system.measureTimeMillis

class LoadScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_screen)
        val timer = object: CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long){

            }
            override fun onFinish(){
                val intent = Intent(this@LoadScreen,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
        timer.start()
    }
}