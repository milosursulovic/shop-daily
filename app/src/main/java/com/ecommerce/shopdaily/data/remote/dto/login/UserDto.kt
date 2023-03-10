package com.ecommerce.shopdaily.data.remote.dto.login


import com.squareup.moshi.Json

data class UserDto(
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
    @Json(name = "token")
    val token: String,
    @Json(name = "username")
    val username: String
)