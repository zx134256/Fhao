package com.example.fhao

import android.annotation.SuppressLint
import android.app.Application
import kotlin.properties.Delegates

@SuppressLint("Registered")
class MyApplication : Application(){

    companion object{
         var instance : MyApplication by Delegates.notNull()

        fun instance() = instance
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}