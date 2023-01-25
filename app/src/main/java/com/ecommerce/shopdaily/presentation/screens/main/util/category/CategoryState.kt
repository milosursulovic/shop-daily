package com.ecommerce.shopdaily.presentation.screens.main.util.category

import com.ecommerce.shopdaily.domain.model.category.Category

data class CategoryState(
    val isLoading: Boolean = false,
    val category: Category? = null,
    val error: String? = null,
    val isCategoryVisible: Boolean = false
)