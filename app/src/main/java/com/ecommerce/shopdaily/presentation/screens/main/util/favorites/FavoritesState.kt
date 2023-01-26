package com.ecommerce.shopdaily.presentation.screens.main.util.favorites

import com.ecommerce.shopdaily.domain.model.product.Product

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<Product>? = null,
    val error: String? = null
)
