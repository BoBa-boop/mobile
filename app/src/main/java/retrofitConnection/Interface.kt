package retrofitConnection

import android.telecom.Call
import recadapters.feel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Interface
{
   @POST("/user/login")
    fun GetAuth (@Body hashMap: HashMap<String,String>):retrofit2.Call<login>

   @GET("feelings")
    fun getFeel():retrofit2.Call<feelings>
   @GET("quotes")
   fun getQuotes():retrofit2.Call<quotes>
}
