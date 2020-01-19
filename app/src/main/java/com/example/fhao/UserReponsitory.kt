package com.example.fhao

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fhao.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserReponsitory {
    private lateinit var webServices : WebServices


    fun getUser(userId : String) : LiveData<User>{
        val data = MutableLiveData<User>()
        val  retrofitB  = Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        webServices = retrofitB.create(WebServices::class.java)
        webServices.getJScd().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("zx fail request", "message =" + t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                /*data.value = response.body()*/
                Log.d("zx","body" + response.body())
            }

        })

        return data
    }

    fun getCd() : String{
        var testStr = ""
        val  retrofitB  = Retrofit.Builder()
            .baseUrl("http://fy.iciba.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        webServices = retrofitB.create(WebServices::class.java)
        webServices.getJScd().enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("zx fail request", "message =" + t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                 testStr = response.body().toString()
                Log.d("zx","body" + response.body())
            }

        })

        return testStr
    }
}