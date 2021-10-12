package com.example.practich

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Response
import retrofitConnection.Interface
import retrofitConnection.MyRetrofit
import retrofitConnection.login

class SignIn : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.email)
        password=findViewById(R.id.password)
    }

    fun sign_in(view: android.view.View) {
        if(email.text.toString().isNotEmpty()&&password.text.toString().isNotEmpty())
        {
            val log = MyRetrofit().getRetofit()
            val getApi = log.create(Interface::class.java)
            val hashmap: HashMap<String,String> = HashMap<String,String>()
            hashmap.put("email",email.text.toString())
            hashmap.put("password", password.text.toString())
            val log_call:Call<login> = getApi.GetAuth(hashmap)
            log_call.enqueue(object : retrofit2.Callback<login> {
                override fun onResponse(call:Call<login>, response: Response<login>){
                    if(response.isSuccessful){
                        val intent = Intent(this@SignIn,MenuActivity2::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@SignIn,t.message,Toast.LENGTH_SHORT).show()
                }
            })


        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .create()
                .show()
        }
    }

}