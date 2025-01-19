package com.ecommerce.shopdaily.data.remote.dto.login


import com.squareup.moshi.Json

data class UserDto(
    @Json(name = "accessToken")
    val accessToken: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "refreshToken")
    val refreshToken: String,
    @Json(name = "username")
    val username: String
)