package com.example.cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }

    fun Redirect(view: android.view.View) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
    }
    fun SignUp(view: android.view.View) {
        val intent = Intent(this, SignIn::class.java)
        startActivity(intent)
        val alert = AlertDialog.Builder(this)
            .setTitle("Регистрация")
            .setMessage("Успешная регистрация")
            .setPositiveButton("Ок", null)
            .create()
            .show()
    }
}