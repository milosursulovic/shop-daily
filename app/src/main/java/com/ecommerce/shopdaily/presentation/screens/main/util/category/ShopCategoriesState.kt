package com.ecommerce.shopdaily.presentation.screens.main.util.category

import com.ecommerce.shopdaily.domain.model.category.ShopCategory

data class ShopCategoriesState(
    val isLoading: Boolean = false,
    val shopCategories: List<ShopCategory>? = null,
    val error: String? = null
)