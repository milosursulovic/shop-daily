package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.mappers.product.toProduct
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavoritesUseCase(private val repository: DummyJsonRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        try {
            val favoritesEntities = repository.getFavorites()
            if (favoritesEntities.isNotEmpty()) {
                val favorites = favoritesEntities.map { favorite -> favorite.toProduct() }
                emit(Resource.Success(favorites))
            } else {
                emit(Resource.Error(""))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}