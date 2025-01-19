package com.ecommerce.shopdaily.data.remote.dto.category


import com.squareup.moshi.Json

data class ProductDto(
    @Json(name = "availabilityStatus")
    val availabilityStatus: String,
    @Json(name = "brand")
    val brand: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "dimensions")
    val dimensions: Dimensions,
    @Json(name = "discountPercentage")
    val discountPercentage: Double,
    @Json(name = "id")
    val id: Int,
    @Json(name = "images")
    val images: List<String>,
    @Json(name = "meta")
    val meta: Meta,
    @Json(name = "minimumOrderQuantity")
    val minimumOrderQuantity: Int,
    @Json(name = "price")
    val price: Double,
    @Json(name = "rating")
    val rating: Double,
    @Json(name = "returnPolicy")
    val returnPolicy: String,
    @Json(name = "reviews")
    val reviews: List<Review>,
    @Json(name = "shippingInformation")
    val shippingInformation: String,
    @Json(name = "sku")
    val sku: String,
    @Json(name = "stock")
    val stock: Int,
    @Json(name = "tags")
    val tags: List<String>,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "warrantyInformation")
    val warrantyInformation: String,
    @Json(name = "weight")
    val weight: Int
)