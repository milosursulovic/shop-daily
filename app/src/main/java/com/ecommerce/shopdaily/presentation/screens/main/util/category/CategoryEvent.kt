package com.ecommerce.shopdaily.presentation.screens.main.util.category

sealed class CategoryEvent() {
    data class GetCategory(val token: String) : CategoryEvent()
}