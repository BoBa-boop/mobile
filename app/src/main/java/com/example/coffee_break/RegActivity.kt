package com.example.coffee_break

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class RegActivity : AppCompatActivity() {
    lateinit var user_name: EditText
    lateinit var user_pass: EditText
    lateinit var user_adr: EditText
    lateinit var pattern: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        user_name=findViewById(R.id.txt_reg_login)
        user_pass=findViewById(R.id.txt_reg_password)
        user_adr=findViewById(R.id.txt_reg_address)
        pattern =("[a-z0-9]{1,50}"+
                "\\@"+
                "[a-z]{1,10}"+
                "\\."+
                "[a-z]{1,3}")
    }

    fun EmailValid(email: String): Boolean{
       return compile(pattern).matcher(email).matches()
    }

    fun reg_out(view: android.view.View) {
        if(user_name.text.isNotEmpty()&&user_adr.text.isNotEmpty()&&user_pass.text.isNotEmpty()){
            if(EmailValid(user_name.text.toString())){
                Toast.makeText( this,"Успешная регистрация", Toast.LENGTH_SHORT).show()
            }
            else {
                val alert = AlertDialog.Builder(this,)
                    .setTitle("Ошибка Email")
                    .setMessage("Поле email заполнено неверно")
                    .setPositiveButton("Ок",null)
                    .create()
                    .show()
            }

        }
        else
        {
            val alert = AlertDialog.Builder(this,)
                .setTitle("Ошибка входа")
                .setMessage("Поле пустые")
                .setPositiveButton("Ок",null)
                .create()
                .show()
        }
            //val intent = Intent(this, MainActivity::class.java)
        //startActivity(intent)
    }
}