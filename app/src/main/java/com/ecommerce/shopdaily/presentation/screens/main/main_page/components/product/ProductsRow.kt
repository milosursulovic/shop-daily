package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel

@Composable
fun ProductsRow(
    products: List<Product>,
    mainViewModel: MainViewModel
) {
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(products) { product ->
            ProductCard(product = product, mainViewModel = mainViewModel)
        }
    }
}