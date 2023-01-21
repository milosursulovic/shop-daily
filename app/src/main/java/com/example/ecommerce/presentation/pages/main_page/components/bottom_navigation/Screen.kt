package com.example.ecommerce.presentation.pages.main_page.components.bottom_navigation

sealed class Screen(val route: String) {
    object MainPageScreen : Screen("main_page_screen")
    object ShopScreen : Screen("shop_screen")
    object BagScreen : Screen("bag_screen")
    object FavoritesScreen : Screen("favorites_screen")
    object ProfileScreen : Screen("profile_screen")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}