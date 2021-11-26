package com.example.coffee_break.net

import com.example.coffee_break.login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRet {
    @POST("user/login")
    fun gerAuth(@Body hashMap: HashMap<String,String>):Call<login>


}