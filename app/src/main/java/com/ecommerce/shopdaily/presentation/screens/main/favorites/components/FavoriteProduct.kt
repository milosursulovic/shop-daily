package com.ecommerce.shopdaily.presentation.screens.main.favorites.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.product.*
import com.ecommerce.shopdaily.presentation.ui.theme.Gray

@Composable
fun FavoriteProduct(favorite: Product, onRemoveClick: (Product) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.background(color = MaterialTheme.colors.secondary),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CardImage(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(), favorite.image
            )
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProductSubtitle(product = favorite)
                    IconButton(onClick = {
                        onRemoveClick(favorite)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint = Gray
                        )
                    }
                }
                ProductTitle(product = favorite)
                ColorAndSize()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ProductRating(product = favorite, modifier = Modifier.weight(1f))
                    ProductPrice(product = favorite, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}