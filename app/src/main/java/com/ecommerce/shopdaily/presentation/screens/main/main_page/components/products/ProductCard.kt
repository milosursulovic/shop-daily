package com.ecommerce.shopdaily.presentation.screens.main.main_page.components.products

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.domain.model.Product
import com.ecommerce.shopdaily.presentation.common.components.product.*
import com.ecommerce.shopdaily.presentation.screens.main.MainViewModel
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.main_area.ProductType
import com.ecommerce.shopdaily.presentation.screens.product.ProductActivity
import com.ecommerce.shopdaily.presentation.screens.product.common.Constants
import com.ecommerce.shopdaily.presentation.ui.theme.Black
import com.ecommerce.shopdaily.presentation.ui.theme.Hot
import com.ecommerce.shopdaily.presentation.ui.theme.White

@Composable
fun ProductCard(
    product: Product,
    mainViewModel: MainViewModel
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val result = activityResult.data?.getBooleanExtra(Constants.ADD_TO_CART, false)
            if (result == true) {
                mainViewModel.addProduct(product)
            }
        }
    }
    Column(
        modifier = Modifier.clickable {
            val intent = Intent(context, ProductActivity::class.java).apply {
                putExtra(Constants.PRODUCT, product)
            }
            launcher.launch(intent)
        }
    ) {
        Box {
            Image(
                painter = painterResource(id = product.image),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = when (product.productType) {
                        is ProductType.New -> "NEW"
                        is ProductType.Sale -> "-${product.discount}%"
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            when (product.productType) {
                                is ProductType.New -> Black
                                is ProductType.Sale -> Hot
                            }
                        )
                        .padding(5.dp),
                    style = MaterialTheme.typography.h4,
                    color = White
                )
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
        Spacer(modifier = Modifier.height(10.dp))
        ProductRating(product = product)
        ProductSubtitle(product = product)
        ProductTitle(product = product)
        ProductPrice(product = product, modifier = Modifier.fillMaxWidth())
    }
}