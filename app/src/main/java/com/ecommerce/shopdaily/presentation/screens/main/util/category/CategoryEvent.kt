package com.ecommerce.shopdaily.presentation.screens.main.util.category

sealed class CategoryEvent() {
    data class GetCategory(val token: String, val categoryId: String, val name: String) :
        CategoryEvent()

    object CloseCategory : CategoryEvent()
}