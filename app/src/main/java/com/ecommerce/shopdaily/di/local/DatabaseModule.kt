package com.ecommerce.shopdaily.di.local

import android.app.Application
import androidx.room.Room
import com.ecommerce.shopdaily.data.db.ShopDailyDao
import com.ecommerce.shopdaily.data.db.ShopDailyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(app: Application): ShopDailyDatabase =
        Room.databaseBuilder(
            app,
            ShopDailyDatabase::class.java,
            ShopDailyDatabase.DATABASE_NAME
        )
            .build()

    @Singleton
    @Provides
    fun providesDao(db: ShopDailyDatabase): ShopDailyDao = db.dao
}