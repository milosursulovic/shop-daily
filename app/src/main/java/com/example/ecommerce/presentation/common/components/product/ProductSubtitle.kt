package com.example.ecommerce.presentation.common.components.product

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun ProductSubtitle(product: Product) {
    Text(
        text = product.subtitle,
        style = MaterialTheme.typography.h4,
        color = Gray,
    )
}