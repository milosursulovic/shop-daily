package com.ecommerce.shopdaily.domain.repository

import com.ecommerce.shopdaily.data.db.entities.ProductEntity
import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.data.remote.dto.category.ProductCategoriesDto
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import retrofit2.Response

interface DummyJsonRepository {
    suspend fun login(username: String, password: String): Response<UserDto>

    suspend fun getSavedUser(): List<UserEntity>

    suspend fun saveUser(user: UserEntity): Long

    suspend fun getCategories(token: String): Response<List<ProductCategoriesDto>>

    suspend fun getCategory(token: String, categoryId: String): Response<CategoryDto>

    suspend fun saveProductToFavorites(product: ProductEntity): Long

    suspend fun getFavorites(): List<ProductEntity>

    suspend fun deleteFromFavorites(productId: Int, category: String)

    suspend fun getProducts(token: String, skip: Int = 0): Response<CategoryDto>
}