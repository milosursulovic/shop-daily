package com.ecommerce.shopdaily.domain.model.product

import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
import java.io.Serializable

data class Product(
    val image: String,
    val title: String,
    val subtitle: String,
    val price: Int,
    val discount: Double,
    val rating: Double,
    val description: String,
    val productType: ProductType,
    val images: List<String>
) : Serializable