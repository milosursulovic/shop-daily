package com.example.ecommerce.presentation.screens.product

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.Modifier
import com.example.ecommerce.presentation.common.components.appbar.AppBar
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
                    Scaffold(
                        topBar = {
                            AppBar(
                                title = "Short dress",
                                actions = arrayOf(Icons.Default.Share),
                                onBackPressed = {}
                            )
                        },
                        content = {

                        }
                    )
                }
            }
        }
    }
}