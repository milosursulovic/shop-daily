package com.example.ecommerce.presentation.pages.main_page.components.products

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.pages.main_page.util.main_area.AreaType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Gray
import com.example.ecommerce.presentation.ui.theme.Hot
import com.example.ecommerce.presentation.ui.theme.StartYellow

@Composable
fun ProductBottomArea(
    areaType: AreaType,
    product: Product
) {
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
            text = "(${product.discount})",
            style = MaterialTheme.typography.h4,
            color = Gray
        )
    }
    Text(
        text = product.subtitle,
        style = MaterialTheme.typography.h4,
        color = Gray,
    )
    Text(
        text = product.title,
        style = MaterialTheme.typography.body1,
        color = Black,
        fontWeight = FontWeight.Bold
    )
    Row(verticalAlignment = Alignment.CenterVertically) {
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
            text = "${product.discount}$",
            style = MaterialTheme.typography.body2,
            color = Hot
        )
    }
}