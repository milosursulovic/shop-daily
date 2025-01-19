package com.ecommerce.shopdaily.domain.model.product

import java.io.Serializable

data class Product(
    val productId: Int,
    val image: String,
    val title: String,
    val subtitle: String,
    val price: Double,
    val discount: Double,
    val rating: Double,
    val description: String,
    val images: List<String>,
    val category: String
) : Serializable