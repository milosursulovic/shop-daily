@file:Suppress("DEPRECATION")

package com.example.ecommerce.presentation.screens.product

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.ecommerce.domain.model.Product
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.screens.product.common.Constants
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme
import com.example.ecommerce.presentation.ui.theme.Success

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
                    println("debugtag: ${product.price}")
                    BackHandler {
                        val data = Intent().apply {
                            putExtra(Constants.ADD_TO_CART, true)
                        }
                        setResult(Activity.RESULT_OK, data)
                        (context as ComponentActivity).finish()
                    }
                    Scaffold(
                        topBar = {
                            AppBar(
                                title = "Short dress",
                                actions = arrayOf(Icons.Default.Share),
                                onBackPressed = {}
                            )
                        },
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Success)
                            ) {
                                Image(
                                    painter = painterResource(id = product.image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight(0.6f),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    )
                }
            }
        }
    }
}