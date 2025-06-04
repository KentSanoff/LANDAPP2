package com.kentsanoff.landapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "land_fields")
data class LandField(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val cropType: String,
    val editDate: String,
    val notes: String
)
