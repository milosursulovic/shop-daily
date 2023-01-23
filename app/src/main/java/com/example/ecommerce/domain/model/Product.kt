package com.example.ecommerce.domain.model

import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType
import java.io.Serializable

data class Product(
    val image: Int,
    val title: String,
    val subtitle: String,
    val price: Double,
    val discount: Int,
    val rating: Double,
    val description: String,
    val productType: ProductType
) : Serializable