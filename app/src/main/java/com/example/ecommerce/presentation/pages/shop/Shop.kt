package com.example.ecommerce.presentation.pages.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.ui.theme.Success

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Shop() {
    Scaffold(
        topBar = {
            AppBar(title = "Categories", onBackClick = {}, actions = arrayOf(Icons.Outlined.Search))
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Success)
            ) {

            }
        }
    )
}