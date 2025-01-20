package com.ecommerce.shopdaily.domain.model.login

import java.io.Serializable

data class User(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val gender: String,
    val accessToken: String,
    val refreshToken: String,
) : Serializable
