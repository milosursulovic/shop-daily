package com.ecommerce.shopdaily.presentation.screens.main.util.product

import com.ecommerce.shopdaily.domain.model.product.Product

open class ProductBaseState(
    val isLoading: Boolean = false,
    val products: List<Product>? = null,
    val error: String? = null
)