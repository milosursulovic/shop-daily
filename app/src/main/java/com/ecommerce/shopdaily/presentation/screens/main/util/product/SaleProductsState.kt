package com.ecommerce.shopdaily.presentation.screens.main.util.product

import com.ecommerce.shopdaily.domain.model.product.Product

data class SaleProductsState(
    val loading: Boolean = false,
    val saleProducts: List<Product>? = null,
    val errorMsg: String? = null
) : ProductBaseState(loading, saleProducts, errorMsg)