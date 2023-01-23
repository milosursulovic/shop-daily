package com.example.ecommerce.presentation.screens.main.shop.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Category
import com.example.ecommerce.presentation.common.components.product.CardImage

@Composable
fun ProductCategory(category: Category) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.background(color = MaterialTheme.colors.secondary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = category.title,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )
            CardImage(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(), category.image
            )
        }
    }
}