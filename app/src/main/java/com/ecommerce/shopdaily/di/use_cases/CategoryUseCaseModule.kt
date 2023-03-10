package com.ecommerce.shopdaily.di.use_cases

import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import com.ecommerce.shopdaily.domain.use_cases.remote.category.GetCategoriesUseCase
import com.ecommerce.shopdaily.domain.use_cases.remote.category.GetCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoryUseCaseModule {
    @Singleton
    @Provides
    fun providesGetCategoriesUseCase(repository: DummyJsonRepository): GetCategoriesUseCase =
        GetCategoriesUseCase(repository)

    @Singleton
    @Provides
    fun providesGetCategoryUseCase(repository: DummyJsonRepository): GetCategoryUseCase =
        GetCategoryUseCase(repository)
}