package com.example.fhao.ui.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fhao.UserReponsitory

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val userReponsitory: UserReponsitory) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(userReponsitory) as T
    }
}