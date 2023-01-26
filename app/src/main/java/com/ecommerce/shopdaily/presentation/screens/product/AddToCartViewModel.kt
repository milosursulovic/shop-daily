package com.ecommerce.shopdaily.presentation.screens.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.domain.use_cases.local.DeleteFromFavoritesUseCase
import com.ecommerce.shopdaily.domain.use_cases.local.GetFavoritesUseCase
import com.ecommerce.shopdaily.domain.use_cases.local.SaveToFavoritesUseCase
import com.ecommerce.shopdaily.presentation.screens.main.util.favorites.FavoritesState
import com.ecommerce.shopdaily.presentation.screens.main.util.product.ProductEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddToCartViewModel @Inject constructor(
    private val deleteFromFavoritesUseCase: DeleteFromFavoritesUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val saveToFavoritesUseCase: SaveToFavoritesUseCase
) : ViewModel() {
    var screenLoadingState by mutableStateOf(false)
        private set
    var favoritesState by mutableStateOf(FavoritesState())
        private set

    init {
        getFavorites()
    }

    fun onProductEvent(event: ProductEvent) {
        when (event) {
            is ProductEvent.DeleteFromFavorites -> deleteFromFavorites(event.product)
            is ProductEvent.SaveToFavorites -> saveToFavorites(event.product)
            else -> {}
        }
    }

    private fun saveToFavorites(product: Product) {
        viewModelScope.launch {
            saveToFavoritesUseCase(product).collect { result ->
                screenLoadingState = when (result) {
                    is Resource.Loading -> true
                    is Resource.Success -> {
                        getFavorites()
                        false
                    }
                    is Resource.Error -> false
                }
            }
        }
    }

    private fun deleteFromFavorites(product: Product) {
        viewModelScope.launch {
            deleteFromFavoritesUseCase(product).collect { result ->
                screenLoadingState = when (result) {
                    is Resource.Loading -> true
                    is Resource.Success -> {
                        getFavorites()
                        false
                    }
                    is Resource.Error -> false
                }
            }
        }
    }

    private fun getFavorites() {
        viewModelScope.launch {
            getFavoritesUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        favoritesState = favoritesState.copy(
                            isLoading = true,
                            favorites = null,
                            error = null
                        )
                    }
                    is Resource.Success -> {
                        result.data?.let { favorites ->
                            favoritesState = favoritesState.copy(
                                isLoading = false,
                                favorites = favorites,
                                error = null
                            )
                        }
                    }
                    is Resource.Error -> {
                        result.message?.let { errorMsg ->
                            favoritesState = favoritesState.copy(
                                isLoading = false,
                                favorites = null,
                                error = errorMsg
                            )
                        }
                    }
                }
            }
        }
    }
}