package com.example.fhao

import com.example.fhao.data.Student
import com.example.fhao.data.StudentDao
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 +2)
    }

   /* @Test
    fun roomBaseInsert(){
        val studentDao = AppDataBase.instance!!.getStudentDao()
        val sList :MutableList<Student> = mutableListOf()
        for (i in 1..10){
            val sex : String = if (i % 2 == 0){
                "man"
            } else{
                "women"
            }
            sList.add(Student(i,"test%$i",sex))
        }
        studentDao.insertAll(sList)
    }*/

    @Test
    fun getMyApp(){
        print(MyApplication.instance().packageName)
    }
}
