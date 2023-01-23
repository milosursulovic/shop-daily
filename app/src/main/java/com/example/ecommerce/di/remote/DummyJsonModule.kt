package com.example.ecommerce.di.remote

import android.app.Application
import com.example.ecommerce.data.remote.DummyJsonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DummyJsonModule {
    @Singleton
    @Provides
    fun providesDummyJsonService(app: Application): DummyJsonService =
        Retrofit.Builder()
            .baseUrl(DummyJsonService.API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DummyJsonService::class.java)
}