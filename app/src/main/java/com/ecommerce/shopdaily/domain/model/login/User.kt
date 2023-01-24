package com.ecommerce.shopdaily.domain.model.login

import java.io.Serializable

data class User(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val token: String
) : Serializable
