package com.cookandroid.sqlite

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDAO {
    @Query("SELECT * FROM IdolEntity;")
    fun getIdolList(): List<IdolEntity>
    @Insert
    fun addIdol(idol: IdolEntity)
    @Query("DELETE FROM IdolEntity WHERE true;")
    fun clearIdolList()
}