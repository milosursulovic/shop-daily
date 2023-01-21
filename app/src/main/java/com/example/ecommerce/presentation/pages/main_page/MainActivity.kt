package com.example.ecommerce.presentation.pages.main_page

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.common.components.AppBar
import com.example.ecommerce.presentation.navigation.Screen
import com.example.ecommerce.presentation.pages.login.Login
import com.example.ecommerce.presentation.pages.main_page.MainPage
import com.example.ecommerce.presentation.pages.main_page.components.MainBottomNavigation
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme
import com.example.ecommerce.presentation.ui.theme.Success

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    Column(modifier = Modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier.fillMaxWidth()
                                .fillMaxHeight(0.8f)
                                .background(Success)
                        ) {
                            NavHost(
                                navController = navController,
                                startDestination = Screen.MainPageScreen.route
                            ) {
                                composable(route = Screen.MainPageScreen.route) {
                                    MainPage()
                                }
                            }
                        }
                        MainBottomNavigation()
                    }
                }
            }
        }
    }
}