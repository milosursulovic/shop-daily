package com.ecommerce.shopdaily.domain.model.category

import com.ecommerce.shopdaily.domain.model.product.Product

data class Category(
    val categoryId: String,
    val name: String,
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)
