package com.example.fhao.utils

import android.content.Context
import com.example.fhao.AppDataBase
import com.example.fhao.StudentResponsitory
import com.example.fhao.data.StudentDao
import com.example.fhao.ui.main.StudentModelFactory

object InJectorUtils {

    private fun getStudentResponsitory() : StudentResponsitory{
        return StudentResponsitory.getInstance(AppDataBase.getAppDataBase().getStudentDao())
    }

     fun provideStudentModelFactory() : StudentModelFactory{
        return StudentModelFactory(getStudentResponsitory())
    }
}