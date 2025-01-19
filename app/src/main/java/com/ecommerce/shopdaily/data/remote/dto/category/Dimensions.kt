package com.ecommerce.shopdaily.data.remote.dto.category


import com.squareup.moshi.Json

data class Dimensions(
    @Json(name = "depth")
    val depth: Double,
    @Json(name = "height")
    val height: Double,
    @Json(name = "width")
    val width: Double
)