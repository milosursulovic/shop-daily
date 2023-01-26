package com.ecommerce.shopdaily.presentation.screens.main.util.product

import com.ecommerce.shopdaily.domain.model.product.Product

data class NewProductsState(
    val loading: Boolean = false,
    val newProducts: List<Product>? = null,
    val errorMsg: String? = null
) : ProductBaseState(loading, newProducts, errorMsg)