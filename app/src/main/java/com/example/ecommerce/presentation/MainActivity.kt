package com.example.ecommerce.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme

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
                    Scaffold(
                        topBar = {
                            AppBar() {

                            }
                        }
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.LoginScreen.route
                        ) {
                            composable(route = Screen.LoginScreen.route) {
                                Login()
                            }
                            composable(route = Screen.MainPageScreen.route) {
                                MainPage()
                            }
                        }
                    }
                }
            }
        }
    }
}