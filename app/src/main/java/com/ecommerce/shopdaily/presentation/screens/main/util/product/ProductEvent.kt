package com.ecommerce.shopdaily.presentation.screens.main.util.product

import com.ecommerce.shopdaily.domain.model.product.Product

sealed class ProductEvent {
    data class SaveToFavorites(val product: Product) : ProductEvent()
    object GetFavorites : ProductEvent()
}