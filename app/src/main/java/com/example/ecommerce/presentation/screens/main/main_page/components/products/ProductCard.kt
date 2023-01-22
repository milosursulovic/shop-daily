package com.example.ecommerce.presentation.screens.main.main_page.components.products

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.common.components.product.ProductFavorite
import com.example.ecommerce.presentation.common.components.product.ProductPrice
import com.example.ecommerce.presentation.common.components.product.ProductSubtitle
import com.example.ecommerce.presentation.common.components.product.ProductTitle
import com.example.ecommerce.presentation.common.components.product.ProductRating
import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType
import com.example.ecommerce.presentation.screens.product.ProductActivity
import com.example.ecommerce.presentation.screens.product.common.Constants
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Hot
import com.example.ecommerce.presentation.ui.theme.White

@Composable
fun ProductCard(
    product: Product
) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val result = activityResult.data?.getBooleanExtra(Constants.ADD_TO_CART, false)
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
            ProductFavorite(
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 0.dp, y = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProductRating(product = product)
        ProductSubtitle(product = product)
        ProductTitle(product = product)
        ProductPrice(product = product)
    }
}