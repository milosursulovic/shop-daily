package com.example.ecommerce.domain.model.login

data class User(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val image: String,
    val token: String
)
