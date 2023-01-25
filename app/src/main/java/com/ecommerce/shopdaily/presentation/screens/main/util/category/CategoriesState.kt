package com.ecommerce.shopdaily.presentation.screens.main.util.category

import com.ecommerce.shopdaily.domain.model.Category

data class CategoriesState(
    val isLoading: Boolean = false,
    val categories: List<Category>? = null,
    val error: String? = null
)