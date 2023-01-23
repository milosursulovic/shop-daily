package com.example.ecommerce.data.remote

import com.example.ecommerce.data.remote.dto.login.UserDto
import retrofit2.Response
import retrofit2.http.GET

interface DummyJsonService {
    @GET("auth/login")
    suspend fun login(): Response<UserDto>

    companion object {
        const val API_URL = "https://dummyjson.com/"
    }
}