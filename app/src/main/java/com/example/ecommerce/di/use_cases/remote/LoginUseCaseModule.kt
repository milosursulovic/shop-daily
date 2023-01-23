package com.example.ecommerce.di.use_cases.remote

import com.example.ecommerce.domain.repository.DummyJsonRepository
import com.example.ecommerce.domain.use_cases.remote.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginUseCaseModule {
    @Singleton
    @Provides
    fun providesLoginUseCase(repository: DummyJsonRepository): LoginUseCase =
        LoginUseCase(repository)
}