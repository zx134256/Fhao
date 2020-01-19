package com.example.fhao.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TeacherDao : BaseDao<Teacher>{

    @Query(value = "select * from Teacher")
    fun getTeachers() : LiveData<List<Teacher>>
}