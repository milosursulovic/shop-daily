package com.example.ecommerce.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecommerce.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class ECommerceDatabase : RoomDatabase() {
    abstract val dao: ECommerceDao

    companion object {
        const val DATABASE_NAME = "ecommerce_db"
    }
}