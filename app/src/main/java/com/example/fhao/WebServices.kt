package com.example.fhao

import com.example.fhao.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServices {

    @GET("/users/{user}")
    fun getUser(@Path("user")userid : String) : Call<User>

    fun getJScd() : Call<String>
}