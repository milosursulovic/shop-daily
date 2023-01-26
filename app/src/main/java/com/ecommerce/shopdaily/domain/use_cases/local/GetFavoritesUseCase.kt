package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.domain.model.product.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetFavoritesUseCase {
    suspend operator fun invoke(): Flow<Resource<List<Product>>> = flow {

    }
}