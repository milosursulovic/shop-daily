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
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.screens.main.main_page.util.main_area.ProductType
import com.example.ecommerce.presentation.screens.product.ProductActivity
import com.example.ecommerce.presentation.screens.product.common.Constants
import com.example.ecommerce.presentation.ui.theme.*

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
            println("debugtag: $result")
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
            Card(
                elevation = 4.dp,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 0.dp, y = 15.dp),
                shape = RoundedCornerShape(30.dp)
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier
                            .width(15.dp)
                            .height(15.dp),
                        tint = Gray
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
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
                text = "(${product.rating})",
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
            if (product.productType is ProductType.New) {
                Text(
                    text = "${product.price}$",
                    style = MaterialTheme.typography.body2,
                    color = Black
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
}