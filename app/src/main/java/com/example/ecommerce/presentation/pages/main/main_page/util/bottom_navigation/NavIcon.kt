package com.example.ecommerce.presentation.pages.main.main_page.util.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ecommerce.presentation.pages.main.main_page.components.bottom_navigation.Screen

data class NavIcon(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val destination: String
)

val navigationIcons = listOf(
    NavIcon(
        label = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        destination = Screen.MainPageScreen.route
    ),
    NavIcon(
        label = "Shop",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        destination = Screen.ShopScreen.route
    ),
    NavIcon(
        label = "Bag",
        selectedIcon = Icons.Filled.Place,
        unselectedIcon = Icons.Outlined.Place,
        destination = Screen.BagScreen.route
    ),
    NavIcon(
        label = "Favorites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        destination = Screen.FavoritesScreen.route
    ),
    NavIcon(
        label = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        destination = Screen.ProfileScreen.route
    )
)