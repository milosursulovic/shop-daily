package com.example.ecommerce.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.example.ecommerce.domain.model.Product

class MainViewModel : ViewModel() {
    private val _cartProducts = mutableListOf<Product>()
    val cartProducts: List<Product> = _cartProducts

    fun addProduct(product: Product) {
        _cartProducts.add(product)
    }
}