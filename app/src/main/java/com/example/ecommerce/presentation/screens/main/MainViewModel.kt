package com.example.ecommerce.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.example.ecommerce.data.db.FakeDb
import com.example.ecommerce.data.remote.FakeApi
import com.example.ecommerce.domain.model.Category
import com.example.ecommerce.domain.model.Product

class MainViewModel : ViewModel() {
    private val fakeApi = FakeApi()
    private val fakeDb = FakeDb()

    private val _cartProducts = mutableListOf<Product>()
    val cartProducts: List<Product> = _cartProducts

    private val _favorites = fakeDb.getFavorites()
    val favorites: List<Product> = _favorites

    private val _categories = fakeApi.getCategories()
    val categories: List<Category> = _categories

    private val _newProducts = fakeApi.getNewProducts()
    val newProducts: List<Product> = _newProducts

    private val _saleProducts = fakeApi.getSaleProducts()
    val saleProducts: List<Product> = _saleProducts

    fun addProduct(product: Product) {
        _cartProducts.add(product)
    }
}