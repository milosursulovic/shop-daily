package com.example.ecommerce.presentation.common.components.product.rating

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.ui.theme.Gray
import com.example.ecommerce.presentation.ui.theme.StartYellow

@Composable
fun ProductRating(product: Product) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(5) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp),
                tint = StartYellow
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "(${product.rating})",
            style = MaterialTheme.typography.h4,
            color = Gray
        )
    }
}