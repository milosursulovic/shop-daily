package com.ecommerce.shopdaily.data.remote

import com.ecommerce.shopdaily.data.remote.dto.login.LoginRequestBody
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface DummyJsonService {
    @POST("auth/login")
    suspend fun login(@Body body: LoginRequestBody): Response<UserDto>

    @GET("products/categories")
    suspend fun getCategories(@Header("Authorization") token: String): Response<List<String>>

    companion object {
        const val API_URL = "https://dummyjson.com/"
        const val USERNAME = "kminchelle"
        const val PASSWORD = "0lelplR"
    }
}