package com.ecommerce.shopdaily.di.use_cases

import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import com.ecommerce.shopdaily.domain.use_cases.local.DeleteFromFavoritesUseCase
import com.ecommerce.shopdaily.domain.use_cases.local.GetFavoritesUseCase
import com.ecommerce.shopdaily.domain.use_cases.local.SaveToFavoritesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductUseCaseModule {
    @Singleton
    @Provides
    fun providesSaveToFavoritesUseCase(repository: DummyJsonRepository): SaveToFavoritesUseCase =
        SaveToFavoritesUseCase(repository)

    @Singleton
    @Provides
    fun providesGetFavoritesUseCase(repository: DummyJsonRepository): GetFavoritesUseCase =
        GetFavoritesUseCase(repository)

    @Singleton
    @Provides
    fun providesDeleteFromFavoritesUseCase(repository: DummyJsonRepository): DeleteFromFavoritesUseCase =
        DeleteFromFavoritesUseCase(repository)
}