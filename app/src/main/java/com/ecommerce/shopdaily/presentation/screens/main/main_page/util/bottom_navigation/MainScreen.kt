package com.ecommerce.shopdaily.presentation.screens.main.main_page.util.bottom_navigation

sealed class MainScreen(val route: String) {
    data object MainPage : MainScreen("main_page")
    data object ShopPage : MainScreen("shop_page")
    data object BagPage : MainScreen("bag_page")
    data object FavoritesPage : MainScreen("favorites_page")
    data object ProfilePage : MainScreen("profile_page")
}