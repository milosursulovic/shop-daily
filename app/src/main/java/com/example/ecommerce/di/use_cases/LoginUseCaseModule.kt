package com.example.ecommerce.di.use_cases

import com.example.ecommerce.domain.repository.DummyJsonRepository
import com.example.ecommerce.domain.use_cases.local.GetSavedUserUseCase
import com.example.ecommerce.domain.use_cases.local.SaveUserUseCase
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

    @Singleton
    @Provides
    fun providesSaveUserUseCase(repository: DummyJsonRepository): SaveUserUseCase =
        SaveUserUseCase(repository)

    @Singleton
    @Provides
    fun providesGetSavedUserUseCase(repository: DummyJsonRepository): GetSavedUserUseCase =
        GetSavedUserUseCase(repository)
}