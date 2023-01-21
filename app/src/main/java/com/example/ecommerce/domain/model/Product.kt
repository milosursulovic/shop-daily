package com.example.ecommerce.domain.model

data class Product(
    val image: Int,
    val title: String,
    val subtitle: String,
    val price: Double,
    val discount: Int,
    val rating: Double
)