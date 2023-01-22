package com.example.ecommerce.presentation.pages.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.pages.main.main_page.MainPage
import com.example.ecommerce.presentation.pages.main.main_page.components.bottom_navigation.Screen
import com.example.ecommerce.presentation.pages.main.main_page.util.bottom_navigation.navigationIcons
import com.example.ecommerce.presentation.pages.main.shop.Shop
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme
import com.example.ecommerce.presentation.ui.theme.Gray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()
                    var currentDestination by remember {
                        mutableStateOf(
                            navController.currentDestination?.route ?: Screen.MainPageScreen.route
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.MainPageScreen.route,
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                        ) {
                            composable(route = Screen.MainPageScreen.route) {
                                MainPage()
                            }
                            composable(route = Screen.ShopScreen.route) {
                                Shop()
                            }
                            composable(route = Screen.BagScreen.route) {
                                FeedbackLabel(FeedbackType.Info("TO DO"))
                            }
                            composable(route = Screen.FavoritesScreen.route) {
                                FeedbackLabel(FeedbackType.Info("TO DO"))
                            }
                            composable(route = Screen.ProfileScreen.route) {
                                FeedbackLabel(FeedbackType.Info("TO DO"))
                            }
                        }
                        Card(
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.1f)
                                .align(Alignment.BottomCenter),
                            elevation = 5.dp
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                navigationIcons.forEach { navIcon ->
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        IconButton(onClick = {
                                            navController.navigate(navIcon.destination)
                                            currentDestination =
                                                navController.currentDestination?.route!!
                                        }) {
                                            Icon(
                                                if (navIcon.destination == currentDestination) navIcon.selectedIcon else navIcon.unselectedIcon,
                                                null,
                                                modifier = Modifier.size(30.dp),
                                                tint = if (navIcon.destination == currentDestination) MaterialTheme.colors.primary else Gray
                                            )
                                        }
                                        Text(
                                            text = navIcon.label,
                                            style = MaterialTheme.typography.h4,
                                            color = if (navIcon.destination == currentDestination) MaterialTheme.colors.primary else Gray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}