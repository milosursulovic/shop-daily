package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.data.remote.dto.category.ProductCategoriesDto
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.data.remote.dto.login.request.LoginRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface DummyJsonService {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestBody): Response<UserDto>

    @GET("products/categories")
    suspend fun getCategories(@Header("Authorization") token: String): Response<List<ProductCategoriesDto>>

    @GET("products/category/{category}")
    suspend fun getCategory(
        @Header("Authorization") token: String,
        @Path("category") categoryId: String
    ): Response<CategoryDto>

    @GET("products")
    suspend fun getProducts(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int = 10,
        @Query("skip") skip: Int = 0
    ): Response<CategoryDto>

    companion object {
        const val API_URL = "https://dummyjson.com/"
    }
}