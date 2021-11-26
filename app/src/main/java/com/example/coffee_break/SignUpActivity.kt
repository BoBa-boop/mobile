package com.example.coffee_break

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffee_break.net.ApiRet
import com.example.coffee_break.net.MyRetrofit
import recadapters.skid_coffee
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import java.util.regex.Pattern
import java.util.regex.Pattern.compile


class SignUpActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var checkBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val root = LayoutInflater.from(this).inflate(R.layout.activity_sign_up, null, false)
        val rec_coffee : RecyclerView = findViewById(R.id.rec)
        rec_coffee.adapter = skid_coffee(this,Skid_coffee().list)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        checkBox = findViewById(R.id.cb_save)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
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
        check()
        if (email.text.toString().isNotEmpty()&&password.text.toString().isNotEmpty()){
            if(EmailValid((email.text.toString()))){
                val log = MyRetrofit().GetRetrofit()
                val getApi = log.create(ApiRet::class.java)
                val hashMap: HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email",email.text.toString())
                hashMap.put("password", password.text.toString())
                val log_call: retrofit2.Call<login> = getApi.gerAuth(hashMap)
                log_call.enqueue(object : retrofit2.Callback<login>{
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                       if(response.isSuccessful){
                           val editor = sharedPreferences.edit()
                           editor.putString("email", response.body()?.email)//? - поле не пустое используется библиотека glide
                           editor.putString("avatar", response.body()?.avatar)
                           editor.putString("name", response.body()?.nickName)
                           editor.putString("id",response.body()?.id)
                           editor.putBoolean("save",true)
                           editor.apply()
                           //check()
                           val intent = Intent(this@SignUpActivity, menuActivity::class.java)
                           startActivity(intent)
                       }
                        //логин junior@wsr.ru пароль junior
                        else
                        {
                        Toast.makeText(this@SignUpActivity, "Неверный пароль",Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<login>, t: Throwable) {
                       Toast.makeText(this@SignUpActivity,t.message,Toast.LENGTH_LONG).show()
                    }

                })

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

    fun check() {
        checkBox.setOnCheckedChangeListener{buttonView, isChecked->
            if (isChecked){

            val editor2 = sharedPreferences.edit()
                editor2.putBoolean("save",true)
            val intent = Intent(this@SignUpActivity, menuActivity::class.java)
                startActivity(intent)
        }
            else{
                val editor2 = sharedPreferences.edit()
                editor2.putBoolean("save",false)
                val intent = Intent(this@SignUpActivity, menuActivity::class.java)
                startActivity(intent)
            }
    }

}
}