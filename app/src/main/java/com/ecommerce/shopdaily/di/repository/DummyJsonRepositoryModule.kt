package com.ecommerce.shopdaily.di.repository

import com.ecommerce.shopdaily.data.db.ShopDailyDao
import com.ecommerce.shopdaily.data.remote.DummyJsonService
import com.ecommerce.shopdaily.data.repository.DummyJsonRepositoryImpl
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DummyJsonRepositoryModule {
    @Singleton
    @Provides
    fun providesDummyJsonRepository(api: DummyJsonService, dao: ShopDailyDao): DummyJsonRepository =
        DummyJsonRepositoryImpl(api, dao)
}