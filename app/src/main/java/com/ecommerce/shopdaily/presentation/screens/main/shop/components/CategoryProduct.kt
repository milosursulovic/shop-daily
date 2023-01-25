package com.ecommerce.shopdaily.presentation.screens.main.shop.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.Product
import com.ecommerce.shopdaily.presentation.common.components.product.*

@Composable
fun CategoryProduct(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.background(color = MaterialTheme.colors.secondary),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardImage(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(), product.image
                )
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductTitle(product = product)
                    ProductSubtitle(product = product)
                    ProductRating(product = product)
                    ProductPrice(product = product)
                }
            }
            CircularButton(modifier = Modifier
                .height(30.dp)
                .width(30.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 0.dp, y = 15.dp),
                iconModifier = Modifier
                    .width(15.dp)
                    .height(15.dp),
                icon = Icons.Outlined.FavoriteBorder,
                tint = MaterialTheme.colors.onSecondary,
                onClick = {})
        }
    }
}