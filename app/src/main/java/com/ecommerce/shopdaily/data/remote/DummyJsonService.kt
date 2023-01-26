package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.data.remote.dto.category.CategoryDto
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.data.remote.dto.login.request.LoginRequestBody
import retrofit2.Response
import retrofit2.http.*

interface DummyJsonService {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestBody): Response<UserDto>

    @GET("products/categories")
    suspend fun getCategories(@Header("Authorization") token: String): Response<List<String>>

    @GET("products/category/{category}")
    suspend fun getCategory(
        @Header("Authorization") token: String,
        @Path("category") categoryId: String
    ): Response<CategoryDto>

    companion object {
        const val API_URL = "https://dummyjson.com/"
    }
}