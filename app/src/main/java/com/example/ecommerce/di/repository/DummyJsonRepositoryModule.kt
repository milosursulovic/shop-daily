package com.example.ecommerce.di.repository

import com.example.ecommerce.data.remote.DummyJsonService
import com.example.ecommerce.data.repository.DummyJsonRepositoryImpl
import com.example.ecommerce.domain.repository.DummyJsonRepository
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
    fun providesDummyJsonRepository(api: DummyJsonService): DummyJsonRepository =
        DummyJsonRepositoryImpl(api)
}