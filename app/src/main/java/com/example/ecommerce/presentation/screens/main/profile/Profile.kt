package com.example.ecommerce.presentation.screens.main.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ecommerce.presentation.common.components.appbar.AppBar
import com.example.ecommerce.presentation.common.components.screen.BottomPaddingColumn
import com.example.ecommerce.presentation.common.components.screen.ScreenTitle
import com.example.ecommerce.presentation.screens.main.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Profile(mainViewModel: MainViewModel) {
    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            AppBar(
                isBackEnabled = false,
                onBackPressed = {},
                actions = arrayOf(Icons.Outlined.Search)
            )
        },
        content = {
            BottomPaddingColumn {
                ScreenTitle(title = "My Profile")
            }
        })
}