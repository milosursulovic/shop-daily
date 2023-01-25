package com.ecommerce.shopdaily.presentation.screens.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.db.FakeDb
import com.ecommerce.shopdaily.data.remote.FakeApi
import com.ecommerce.shopdaily.domain.model.Product
import com.ecommerce.shopdaily.domain.model.login.User
import com.ecommerce.shopdaily.domain.use_cases.local.GetSavedUserUseCase
import com.ecommerce.shopdaily.domain.use_cases.remote.GetCategoriesUseCase
import com.ecommerce.shopdaily.presentation.screens.main.util.category.CategoriesState
import com.ecommerce.shopdaily.presentation.screens.main.util.category.CategoryEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSavedUserUseCase: GetSavedUserUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    var loggedUser: User? = null
        private set

    var screenLoadingState by mutableStateOf(true)
        private set

    var categoriesState by mutableStateOf(CategoriesState())
        private set

    init {
        getSavedUser()
    }

    private val fakeApi = FakeApi()
    private val fakeDb = FakeDb()

    private val _cartProducts = mutableListOf<Product>()
    val cartProducts: List<Product> = _cartProducts

    private val _favorites = fakeDb.getFavorites()
    val favorites: List<Product> = _favorites

    private val _newProducts = fakeApi.getNewProducts()
    val newProducts: List<Product> = _newProducts

    private val _saleProducts = fakeApi.getSaleProducts()
    val saleProducts: List<Product> = _saleProducts

    fun addProduct(product: Product) {
        _cartProducts.add(product)
    }

    fun onCategoriesEvent(categoryEvent: CategoryEvent) {
        when (categoryEvent) {
            is CategoryEvent.GetCategory -> getCategory(categoryEvent.token)
        }
    }

    private fun getCategories(token: String) {
        viewModelScope.launch {
            getCategoriesUseCase(token).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        categoriesState = categoriesState.copy(
                            isLoading = true,
                            categories = null,
                            error = null
                        )
                    }
                    is Resource.Success -> {
                        result.data?.let { categories ->
                            categoriesState = categoriesState.copy(
                                isLoading = false,
                                categories = categories,
                                error = null
                            )
                        }
                    }
                    is Resource.Error -> {
                        result.message?.let { errorMsg ->
                            categoriesState = categoriesState.copy(
                                isLoading = false,
                                categories = null,
                                error = errorMsg
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getCategory(token: String) {
        TODO("Not yet implemented")
    }

    private fun getSavedUser() {
        viewModelScope.launch {
            getSavedUserUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        screenLoadingState = true
                    }
                    is Resource.Success -> {
                        screenLoadingState = false
                        result.data?.let { user ->
                            getCategories(user.token)
                        }
                    }
                    is Resource.Error -> {
                        screenLoadingState = false
                    }
                }
            }
        }
    }
}