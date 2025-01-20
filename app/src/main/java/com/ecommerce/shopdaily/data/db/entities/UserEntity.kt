package com.ecommerce.shopdaily.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "firstName")
    val firstName: String,
    @ColumnInfo(name = "lastName")
    val lastName: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "accessToken")
    val accessToken: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "refreshToken")
    val refreshToken: String,
)