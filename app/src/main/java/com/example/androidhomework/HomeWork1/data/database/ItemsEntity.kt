package com.example.androidhomework.HomeWork1.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("ItemsEntity")
data class ItemsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("username")
    val username: String,
    @ColumnInfo("email")
    val email: String,
    @ColumnInfo("street")
    val street: String,
    @ColumnInfo("suite")
    val suite: String,
    @ColumnInfo("city")
    val city: String,
    @ColumnInfo("zipcode")
    val zipcode: String,
    @ColumnInfo("lat")
    val lat: String,
    @ColumnInfo("lng")
    val lng: String,
    @ColumnInfo("phone")
    val phone: String,
    @ColumnInfo("website")
    val website: String,
    @ColumnInfo("companyName")
    val companyName: String,
    @ColumnInfo("catchPhrase")
    val catchPhrase: String,
    @ColumnInfo("bs")
    val bs: String,
    @ColumnInfo("favorite")
    val favorite: Boolean
)
