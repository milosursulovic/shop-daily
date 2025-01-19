package com.ecommerce.shopdaily.data.remote.dto.category


import com.squareup.moshi.Json

data class Review(
    @Json(name = "comment")
    val comment: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "rating")
    val rating: Int,
    @Json(name = "reviewerEmail")
    val reviewerEmail: String,
    @Json(name = "reviewerName")
    val reviewerName: String
)