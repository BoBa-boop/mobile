package com.example.coffee_break

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.prefs.AbstractPreferences

class ProfileActivity : AppCompatActivity() {
    lateinit var names:TextView
    lateinit var email:TextView
    lateinit var id1:TextView
    lateinit var imageView: ImageView
    lateinit var sharePreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        names = findViewById(R.id.name_act)
        email = findViewById(R.id.email_prof)
        id1 = findViewById(R.id.id_prof)
        imageView = findViewById(R.id.prof_act)
        sharePreferences = getSharedPreferences("main", MODE_PRIVATE)
        val na:String = sharePreferences.getString("name", null)!!
        val em:String = sharePreferences.getString("email",null)!!
        val id:String = sharePreferences.getString("id",null)!!
        val avatar:String = sharePreferences.getString("avatar",null)!!
        names.text=na
        email.text=em
        id1.text=id
        Glide.with(applicationContext).load(avatar).circleCrop().into(imageView)

    }

    fun Exit_prof(view: android.view.View) {
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        val editor = sharePreferences.edit()
        editor.putString("name",null)
        editor.putString("email",null)
        editor.putString("id",null)
        editor.putString("avatar",null)
        editor.putBoolean("save",false)
        editor.apply()
        finish()
    }
}