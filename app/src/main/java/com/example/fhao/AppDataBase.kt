package com.example.fhao

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.fhao.data.Student
import com.example.fhao.data.StudentDao
import com.example.fhao.data.Teacher
import com.example.fhao.data.TeacherDao

@Database(entities = [Student::class, Teacher::class], version = 1)
abstract class AppDataBase : RoomDatabase(){

    abstract fun getStudentDao() : StudentDao

    abstract fun getTeacherDao() : TeacherDao


    companion object{
        @Volatile
         var instance : AppDataBase?= null

        fun getAppDataBase() : AppDataBase{
            if (instance == null){
                synchronized(this){
                    if (instance == null){
                        instance = Room.databaseBuilder(MyApplication.instance,AppDataBase::class.java,"User.db").allowMainThreadQueries().build()
                    }
                }
            }
            return instance!!
        }
    }

}