package com.ecommerce.shopdaily.data.remote.dto.category


import com.squareup.moshi.Json

data class Meta(
    @Json(name = "barcode")
    val barcode: String,
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "qrCode")
    val qrCode: String,
    @Json(name = "updatedAt")
    val updatedAt: String
)