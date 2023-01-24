package com.example.ecommerce.data.remote.dto.login

import com.squareup.moshi.Json

data class LoginRequestBody(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)
