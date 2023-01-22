package com.example.ecommerce.presentation.common.components.product

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.ecommerce.domain.model.Product

@Composable
fun ProductTitle(product: Product) {
    Text(
        text = product.title,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onBackground,
        fontWeight = FontWeight.Bold
    )
}