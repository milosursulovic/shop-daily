package com.ecommerce.shopdaily.presentation.common.components.product

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.ui.theme.Gray

@Composable
fun ProductSubtitle(product: Product) {
    Text(
        text = product.subtitle,
        style = MaterialTheme.typography.h4,
        color = Gray,
    )
}