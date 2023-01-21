package com.example.ecommerce.presentation.pages.main_page.components.products

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.ecommerce.domain.model.Product

@Composable
fun ProductCard(
    product: Product
) {
    Column {
        ProductTopArea(product)
    }
}