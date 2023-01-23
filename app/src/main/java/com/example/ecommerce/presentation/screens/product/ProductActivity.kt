@file:Suppress("DEPRECATION")

package com.example.ecommerce.presentation.screens.product

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.common.components.button.CustomButton
import com.example.ecommerce.presentation.common.components.product.*
import com.example.ecommerce.presentation.common.components.spinner.CustomSpinner
import com.example.ecommerce.presentation.common.util.spinner.SpinnerType
import com.example.ecommerce.presentation.screens.product.common.Constants
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme

class ProductActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    val product = intent.extras?.getSerializable(Constants.PRODUCT) as Product
                    BackHandler {
                        sendResult(context, false)
                    }
                    Scaffold(
                        topBar = {
                            AppBar(
                                title = product.title,
                                actions = arrayOf(Icons.Outlined.Share),
                                onBackPressed = {}
                            )
                        },
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState())
                            ) {
                                Image(
                                    painter = painterResource(id = product.image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.6f),
                                    contentScale = ContentScale.Crop
                                )
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceAround,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        CustomSpinner(SpinnerType.Size)
                                        CustomSpinner(SpinnerType.Color)
                                        ProductFavorite(
                                            modifier = Modifier
                                                .height(40.dp)
                                                .width(40.dp)
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        ProductTitle(product = product)
                                        ProductPrice(
                                            product = product,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                    ProductSubtitle(product = product)
                                    ProductRating(product = product)
                                    Text(text = product.description)
                                    Spacer(modifier = Modifier.height(20.dp))
                                    CustomButton(modifier = Modifier
                                        .fillMaxWidth(),
                                        textModifier = Modifier.padding(vertical = 10.dp),
                                        text = "ADD TO CART",
                                        onClick = {
                                            sendResult(context, true)
                                        })
                                }
                            }
                        }
                    )
                }
            }
        }
    }

    private fun sendResult(context: Context, result: Boolean) {
        val data = Intent().apply {
            putExtra(Constants.ADD_TO_CART, result)
        }
        setResult(Activity.RESULT_OK, data)
        (context as ComponentActivity).finish()
    }
}