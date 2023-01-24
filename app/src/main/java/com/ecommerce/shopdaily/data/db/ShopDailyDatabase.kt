package com.ecommerce.shopdaily.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ecommerce.shopdaily.data.db.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class ShopDailyDatabase : RoomDatabase() {
    abstract val dao: ShopDailyDao

    companion object {
        const val DATABASE_NAME = "ecommerce_db"
    }
}