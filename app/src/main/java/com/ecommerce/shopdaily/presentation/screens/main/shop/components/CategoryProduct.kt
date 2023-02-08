package com.ecommerce.shopdaily.presentation.screens.main.shop.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.product.*
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel

@Composable
fun CategoryProduct(
    viewModel: MainViewModel,
    product: Product,
    onProductClick: (Product) -> Unit,
    onFavoriteClick: (Product) -> Unit,
    onDeleteFavoriteClick: (Product) -> Unit
) {
    val found = viewModel.favoritesState.favorites?.find { indexedProduct ->
        indexedProduct.productId == product.productId && indexedProduct.category == product.category
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clickable { onProductClick(product) },
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
        }
        CircularButton(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .align(Alignment.BottomEnd)
                .offset(x = 0.dp, y = 5.dp),
            iconModifier = Modifier
                .width(25.dp)
                .height(25.dp),
            icon = if (found != null) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
            tint = if (found != null) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary,
            onClick = {
                if (found != null) {
                    onDeleteFavoriteClick(product)
                } else {
                    onFavoriteClick(product)
                }
            },
            iconDrawable = null
        )
    }
}