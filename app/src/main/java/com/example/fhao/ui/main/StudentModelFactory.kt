package com.example.fhao.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fhao.StudentResponsitory

@Suppress("UNCHECKED_CAST")
class StudentModelFactory(val studentResponsitory: StudentResponsitory) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StudentModel(studentResponsitory) as T
    }
}