package com.ecommerce.shopdaily.domain.model

import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
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