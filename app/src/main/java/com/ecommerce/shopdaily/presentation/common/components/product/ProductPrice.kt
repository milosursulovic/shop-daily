package com.ecommerce.shopdaily.presentation.common.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.ui.theme.Gray
import com.ecommerce.shopdaily.presentation.ui.theme.Hot

@Composable
fun ProductPrice(product: Product, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        val strikethroughTextStyle = MaterialTheme.typography.body2.copy(
            textDecoration = TextDecoration.LineThrough
        )
        Text(
            text = "${product.price}$",
            style = strikethroughTextStyle,
            color = Gray
        )
        Spacer(modifier = Modifier.width(2.dp))
        Text(
            text = "${product.price - product.discount * 0.01 * product.price}$",
            style = MaterialTheme.typography.body2,
            color = Hot
        )
    }
}