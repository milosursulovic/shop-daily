package com.ecommerce.shopdaily.presentation.screens.main

import androidx.lifecycle.ViewModel
import com.ecommerce.shopdaily.data.db.FakeDb
import com.ecommerce.shopdaily.data.remote.FakeApi
import com.ecommerce.shopdaily.domain.model.Category
import com.ecommerce.shopdaily.domain.model.Product
import com.ecommerce.shopdaily.domain.model.login.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private var _loggedUser: User? = null
    var loggedUser: User? = _loggedUser

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