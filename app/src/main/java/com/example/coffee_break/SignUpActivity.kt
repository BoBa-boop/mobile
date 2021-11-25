package com.example.coffee_break

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import recadapters.skid_coffee
import java.util.regex.Pattern.compile


class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val root = LayoutInflater.from(this).inflate(R.layout.activity_sign_up, null, false)
        val rec_coffee : RecyclerView = findViewById(R.id.rec)
        rec_coffee.adapter = skid_coffee(this,Skid_coffee().list)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
    }
    val paternt = ("[a-z0-9]{1,256}"+
    "\\@"+
    "[a-z]{1,10}"+
    "\\."+
    "[a-z]{1,3}")
    fun EmailValid (email:String):Boolean{
        return compile(paternt).matcher(email).matches()
    }

    fun Registration(view: android.view.View) {
        val intent = Intent(this, RegActivity::class.java)
        startActivity(intent)
    }

    fun Log_In(view: android.view.View) {
        if (email.text.toString().isNotEmpty()&&password.text.toString().isNotEmpty()){
            if(EmailValid((email.text.toString()))){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else if (password.text.toString().isNotEmpty()){
                val alert = AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Неверный email")
                    .create()
                    .show()
            }

        }
        if(password.text.toString().isEmpty()||email.text.toString().isEmpty()){
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("Заполните все поля")
                .setPositiveButton("Ok",null)
                .create()
                .show()
        }
    }
}