package com.example.ecommerce.presentation.pages.main_page

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerce.presentation.pages.main_page.components.bottom_navigation.Screen
import com.example.ecommerce.presentation.pages.main_page.util.bottom_navigation.NavIcon
import com.example.ecommerce.presentation.ui.theme.ECommerceTheme
import com.example.ecommerce.presentation.ui.theme.Gray

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ECommerceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val navController = rememberNavController()
                    val navigationIcons = listOf(
                        NavIcon(
                            label = "Home",
                            selectedIcon = Icons.Filled.Home,
                            unselectedIcon = Icons.Outlined.Home
                        ),
                        NavIcon(
                            label = "Shop",
                            selectedIcon = Icons.Filled.ShoppingCart,
                            unselectedIcon = Icons.Outlined.ShoppingCart
                        ),
                        NavIcon(
                            label = "Bag",
                            selectedIcon = Icons.Filled.Place,
                            unselectedIcon = Icons.Outlined.Place
                        ),
                        NavIcon(
                            label = "Favorites",
                            selectedIcon = Icons.Filled.FavoriteBorder,
                            unselectedIcon = Icons.Outlined.FavoriteBorder
                        ),
                        NavIcon(
                            label = "Profile",
                            selectedIcon = Icons.Filled.Person,
                            unselectedIcon = Icons.Outlined.Person
                        )
                    )
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.MainPageScreen.route,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.9f)
                        ) {
                            composable(route = Screen.MainPageScreen.route) {
                                MainPage()
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            navigationIcons.forEach { navIcon ->
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            if (navIcon.label == "Home") navIcon.selectedIcon else navIcon.unselectedIcon,
                                            null,
                                            modifier = Modifier.size(30.dp),
                                            tint = if (navIcon.label == "Home") MaterialTheme.colors.primary else Gray
                                        )
                                    }
                                    Text(
                                        text = navIcon.label,
                                        style = MaterialTheme.typography.h4,
                                        color = if (navIcon.label == "Home") MaterialTheme.colors.primary else Gray
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