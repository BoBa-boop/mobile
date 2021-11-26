package com.example.coffee_break

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.coffee_break.databinding.ActivityMenuBinding

class menuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
lateinit var  email:TextView
lateinit var name:TextView
lateinit var  imageView: ImageView
lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        val em = sharedPreferences.getString("email",null)
        val na = sharedPreferences.getString("name",null)
        val avatar = sharedPreferences.getString("avatar",null)
        email = findViewById(R.id.email_profile)
        name = findViewById(R.id.name_profile)
        imageView = findViewById(R.id.imageView)
        email.text = em
        name.text = na
        Glide.with(applicationContext).load(avatar).circleCrop().into(imageView)
        imageView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@menuActivity, ProfileActivity::class.java)
                startActivity(intent)
            }

        }

        )
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        navView.setupWithNavController(navController)
    }
}