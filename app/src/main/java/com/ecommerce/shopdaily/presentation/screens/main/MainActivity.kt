package com.ecommerce.shopdaily.presentation.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ecommerce.shopdaily.presentation.screens.main.bag.Bag
import com.ecommerce.shopdaily.presentation.screens.main.favorites.Favorites
import com.ecommerce.shopdaily.presentation.screens.main.main_page.MainPage
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.bottom_navigation.MainScreen
import com.ecommerce.shopdaily.presentation.screens.main.main_page.util.bottom_navigation.navigationIcons
import com.ecommerce.shopdaily.presentation.screens.main.profile.Profile
import com.ecommerce.shopdaily.presentation.screens.main.shop.Shop
import com.ecommerce.shopdaily.presentation.ui.theme.Gray
import com.ecommerce.shopdaily.presentation.ui.theme.ShopDailyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopDailyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val mainViewModel: MainViewModel = viewModel()
                    val context = LocalContext.current
                    val navController = rememberNavController()
                    var currentDestination by remember {
                        mutableStateOf(
                            navController.currentDestination?.route ?: MainScreen.MainPage.route
                        )
                    }
                    LaunchedEffect(key1 = currentDestination) {
                        navController.navigate(currentDestination)
                    }
                    BackHandler {
                        if (navController.currentDestination?.route == MainScreen.MainPage.route) {
                            (context as ComponentActivity).finish()
                        } else {
                            navController.popBackStack()
                            navController.currentDestination?.route?.let {
                                currentDestination = it
                            }
                        }
                    }
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = MainScreen.MainPage.route,
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                        ) {
                            composable(route = MainScreen.MainPage.route) {
                                MainPage(mainViewModel = mainViewModel)
                            }
                            composable(route = MainScreen.ShopPage.route) {
                                Shop(mainViewModel = mainViewModel)
                            }
                            composable(route = MainScreen.BagPage.route) {
                                Bag(mainViewModel = mainViewModel)
                            }
                            composable(route = MainScreen.FavoritesPage.route) {
                                Favorites(mainViewModel = mainViewModel)
                            }
                            composable(route = MainScreen.ProfilePage.route) {
                                Profile(mainViewModel = mainViewModel)
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
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = MaterialTheme.colors.secondary),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                navigationIcons.forEach { navIcon ->
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        IconButton(
                                            onClick = {
                                                currentDestination = navIcon.destination
                                            }
                                        ) {
                                            Icon(
                                                painterResource(
                                                    id =
                                                    if (navIcon.destination == currentDestination)
                                                        if (isSystemInDarkTheme())
                                                            navIcon.selectedIconDark
                                                        else
                                                            navIcon.selectedIcon
                                                    else
                                                        if (isSystemInDarkTheme())
                                                            navIcon.unselectedIconDark
                                                        else
                                                            navIcon.unselectedIcon
                                                ),
                                                null,
                                                modifier = Modifier.size(30.dp),
                                                tint = Color.Unspecified
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