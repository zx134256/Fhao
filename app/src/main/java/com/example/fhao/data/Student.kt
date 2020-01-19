package com.example.fhao.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentId :Int?,

    @ColumnInfo(name = "s_name")
    var studentName : String,

    @ColumnInfo(name = "s_sex")
    var studentSex : String

)