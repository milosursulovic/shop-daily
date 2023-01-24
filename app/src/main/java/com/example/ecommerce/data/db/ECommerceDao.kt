package com.example.ecommerce.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ecommerce.data.db.entities.UserEntity

@Dao
interface ECommerceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: UserEntity): Long

    @Query("select * from login")
    suspend fun getUser(): List<UserEntity>
}