package com.cookandroid.sqlite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [IdolEntity::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun idolDAO(): IdolEntity
}