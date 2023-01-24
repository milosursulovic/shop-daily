package com.example.ecommerce.data.remote

import com.example.ecommerce.data.remote.dto.login.UserDto
import com.example.ecommerce.data.remote.dto.login.UserRequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyJsonService {
    @POST("auth/login")
    suspend fun login(@Body body: UserRequestBody): Response<UserDto>

    companion object {
        const val API_URL = "https://dummyjson.com/"
        const val USERNAME = "kminchelle"
        const val PASSWORD = "0lelplR"
    }
}