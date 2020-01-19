package com.example.fhao

import com.example.fhao.data.StudentDao

class StudentResponsitory private constructor(val studentDao: StudentDao){

    fun getStudents() = studentDao.getStudents()

    companion object{
        @Volatile private var instance : StudentResponsitory? = null

        fun getInstance(studentDao: StudentDao) = instance ?: synchronized(this){
            instance ?: StudentResponsitory(studentDao).also { instance = it }
        }
    }
}