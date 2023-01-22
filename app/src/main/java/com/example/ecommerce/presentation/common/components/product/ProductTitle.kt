package com.example.ecommerce.presentation.common.components.product

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.ui.theme.Black

@Composable
fun ProductTitle(product: Product) {
    Text(
        text = product.title,
        style = MaterialTheme.typography.body1,
        color = Black,
        fontWeight = FontWeight.Bold
    )
}