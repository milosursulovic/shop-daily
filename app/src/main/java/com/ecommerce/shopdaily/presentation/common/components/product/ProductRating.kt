package com.ecommerce.shopdaily.presentation.common.components.product

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
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.ui.theme.Gray
import com.ecommerce.shopdaily.presentation.ui.theme.StartYellow

@Composable
fun ProductRating(product: Product) {
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        val fullStars = product.rating.toInt()
        val halfStars = if (product.rating % 1 >= 0.5) 1 else 0
        val emptyStars = 5 - fullStars - halfStars

        repeat(fullStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp),
                tint = StartYellow
            )
        }

        if (halfStars == 1) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp),
                tint = StartYellow
            )
        }

        repeat(emptyStars) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp),
                tint = Gray
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