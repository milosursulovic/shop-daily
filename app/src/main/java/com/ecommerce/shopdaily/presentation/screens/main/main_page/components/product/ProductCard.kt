package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ecommerce.shopdaily.domain.model.product.Product
import com.ecommerce.shopdaily.presentation.common.components.product.CircularButton
import com.ecommerce.shopdaily.presentation.common.components.product.ProductPrice
import com.ecommerce.shopdaily.presentation.common.components.product.ProductRating
import com.ecommerce.shopdaily.presentation.common.components.product.ProductSubtitle
import com.ecommerce.shopdaily.presentation.common.components.product.ProductTitle
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.util.product.ProductEvent

@Composable
fun ProductCard(
    viewModel: MainViewModel,
    product: Product,
    onProductClick: (Product) -> Unit
) {
    val found = viewModel.favoritesState.favorites?.find { indexedProduct ->
        indexedProduct.productId == product.productId && indexedProduct.category == product.category
    }
    Column(
        modifier = Modifier.clickable { onProductClick(product) }
    ) {
        Box {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp),
                contentScale = ContentScale.Crop
            )
            CircularButton(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 0.dp, y = 15.dp),
                iconModifier = Modifier
                    .width(15.dp)
                    .height(15.dp),
                icon = if (found != null) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                tint = if (found != null) MaterialTheme.colors.primary else MaterialTheme.colors.onSecondary,
                onClick = {
                    if (found != null) {
                        viewModel.onProductEvent(ProductEvent.DeleteFromFavorites(product))
                    } else {
                        viewModel.onProductEvent(ProductEvent.SaveToFavorites(product))
                    }
                },
                iconDrawable = null
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProductRating(product = product)
        ProductSubtitle(product = product)
        ProductTitle(product = product)
        ProductPrice(product = product, modifier = Modifier.fillMaxWidth())
    }
}