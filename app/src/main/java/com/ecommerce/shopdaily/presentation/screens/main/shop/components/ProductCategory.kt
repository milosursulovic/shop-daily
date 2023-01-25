package com.ecommerce.shopdaily.presentation.screens.main.shop.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.category.ShopCategory

@Composable
fun ProductCategory(shopCategory: ShopCategory, onCategoryClick: (ShopCategory) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onCategoryClick(shopCategory) },
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.secondary),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = shopCategory.name,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}