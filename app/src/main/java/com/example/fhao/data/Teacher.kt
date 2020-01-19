package com.example.fhao.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Teacher")
data class Teacher(
    @PrimaryKey(autoGenerate = true)
    var teacherId : Int?,
    @ColumnInfo(name = "t_name")
    var teacherName : String,
    @ColumnInfo(name = "t_sex")
    var teacherSex :String,
    @ColumnInfo(name = "t_year")
    var teacherYear :Int?


)