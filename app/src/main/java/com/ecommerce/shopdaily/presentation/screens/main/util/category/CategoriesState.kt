package com.ecommerce.shopdaily.presentation.screens.main.util.category

import com.ecommerce.shopdaily.domain.model.category.ShopCategory

data class CategoriesState(
    val isLoading: Boolean = false,
    val categories: List<ShopCategory>? = null,
    val error: String? = null
)