package com.example.fhao.data

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: MutableList<T>)

    @Delete
    fun delete(element : T)

    @Update
    fun update(element : T)

}