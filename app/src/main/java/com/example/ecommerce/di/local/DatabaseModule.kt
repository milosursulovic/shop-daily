package com.example.ecommerce.di.local

import android.app.Application
import androidx.room.Room
import com.example.ecommerce.data.db.ECommerceDao
import com.example.ecommerce.data.db.ECommerceDatabase
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
    fun providesDatabase(app: Application): ECommerceDatabase =
        Room.databaseBuilder(
            app,
            ECommerceDatabase::class.java,
            ECommerceDatabase.DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun providesDao(db: ECommerceDatabase): ECommerceDao = db.dao
}