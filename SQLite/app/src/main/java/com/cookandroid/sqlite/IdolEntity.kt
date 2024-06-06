package com.cookandroid.sqlite

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IdolEntity(
    @PrimaryKey val idol_id: Int,
    @ColumnInfo(name="name") val name: String?,
    @ColumnInfo(name="group") val group: String?
)
