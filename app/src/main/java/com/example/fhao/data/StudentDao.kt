package com.example.fhao.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao : BaseDao<Student>{

    @Query(value = "Select *  from Student")
    fun getStudents() : LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Student) : Long

}