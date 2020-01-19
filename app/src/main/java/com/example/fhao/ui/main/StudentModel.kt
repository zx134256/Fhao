package com.example.fhao.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fhao.StudentResponsitory
import com.example.fhao.data.Student

class StudentModel(val studentResponsitory: StudentResponsitory) : ViewModel(){
    val students : LiveData<List<Student>> = studentResponsitory.getStudents()



}