package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeleteFromFavoritesUseCase(private val repository: DummyJsonRepository) {
    suspend operator fun invoke(product: Product): Flow<Resource<Product>> = flow {
        emit(Resource.Loading())
        try {
            repository.deleteFromFavorites(product.productId, product.category)
            emit(Resource.Success(product))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}