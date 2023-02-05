package com.example.androidhomework.HomeWork1.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("HomeEntity")
data class HomeEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("userName")
    val userName: String,
    @ColumnInfo("userPassword")
    val userPassword: String
)