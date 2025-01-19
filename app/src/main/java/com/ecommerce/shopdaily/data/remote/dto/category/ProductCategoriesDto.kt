package com.ecommerce.shopdaily.data.remote.dto.category


import com.squareup.moshi.Json

data class ProductCategoriesDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "slug")
    val slug: String,
    @Json(name = "url")
    val url: String
)