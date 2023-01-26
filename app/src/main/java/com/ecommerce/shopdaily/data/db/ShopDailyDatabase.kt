package com.ecommerce.shopdaily.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.db.entities.UserEntity

@Database(entities = [UserEntity::class, ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ShopDailyDatabase : RoomDatabase() {
    abstract val dao: ShopDailyDao

    companion object {
        const val DATABASE_NAME = "shop_daily_db"
    }
}