package com.ecommerce.shopdaily.data.remote.dto.categories


import com.ecommerce.shopdaily.data.remote.dto.products.ProductDto
import com.squareup.moshi.Json

data class CategoryDto(
    @Json(name = "limit")
    val limit: Int,
    @Json(name = "products")
    val products: List<ProductDto>,
    @Json(name = "skip")
    val skip: Int,
    @Json(name = "total")
    val total: Int
)