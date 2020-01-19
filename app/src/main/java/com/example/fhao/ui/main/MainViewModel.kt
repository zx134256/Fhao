package com.example.fhao.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fhao.model.User
import com.example.fhao.UserReponsitory
import java.lang.IllegalArgumentException

class MainViewModel(userReponsitory: UserReponsitory) : ViewModel() {
    // TODO: Implement the ViewModel
    val userStr : String ="uid" ?: throw IllegalArgumentException( "missing uid")
    var user : LiveData<User> ? = userReponsitory.getUser(userStr)

    init {

    }

}
