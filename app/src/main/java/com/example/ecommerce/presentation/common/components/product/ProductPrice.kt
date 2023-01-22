package com.example.ecommerce.presentation.common.components.product

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType
import com.example.ecommerce.presentation.ui.theme.Gray
import com.example.ecommerce.presentation.ui.theme.Hot

@Composable
fun ProductPrice(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        if (product.productType is ProductType.New) {
            Text(
                text = "${product.price}$",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
        } else {
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
}