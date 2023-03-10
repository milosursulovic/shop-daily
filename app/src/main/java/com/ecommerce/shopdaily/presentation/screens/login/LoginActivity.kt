@file:SuppressLint("UnusedMaterialScaffoldPaddingParameter")

package com.ecommerce.shopdaily.presentation.screens.login

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ecommerce.shopdaily.presentation.common.components.appbar.AppBar
import com.ecommerce.shopdaily.presentation.ui.theme.ShopDailyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopDailyTheme {
                val viewModel: LoginViewModel = hiltViewModel()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colors.background),
                    topBar = {
                        AppBar()
                    },
                    content = {
                        Login(viewModel = viewModel)
                    }
                )
            }
        }
    }
}