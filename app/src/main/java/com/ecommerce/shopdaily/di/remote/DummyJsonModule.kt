package com.ecommerce.shopdaily.di.remote

import com.ecommerce.shopdaily.data.remote.DummyJsonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DummyJsonModule {
    @Singleton
    @Provides
    fun providesDummyJsonService(okHttpClient: OkHttpClient): DummyJsonService =
        Retrofit.Builder()
            .baseUrl(DummyJsonService.API_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DummyJsonService::class.java)
}