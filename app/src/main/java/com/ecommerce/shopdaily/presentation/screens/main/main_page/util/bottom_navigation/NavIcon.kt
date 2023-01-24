package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

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
        destination = MainScreen.MainPage.route
    ),
    NavIcon(
        label = "Shop",
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        destination = MainScreen.ShopPage.route
    ),
    NavIcon(
        label = "Bag",
        selectedIcon = Icons.Filled.Place,
        unselectedIcon = Icons.Outlined.Place,
        destination = MainScreen.BagPage.route
    ),
    NavIcon(
        label = "Favorites",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        destination = MainScreen.FavoritesPage.route
    ),
    NavIcon(
        label = "Profile",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        destination = MainScreen.ProfilePage.route
    )
)