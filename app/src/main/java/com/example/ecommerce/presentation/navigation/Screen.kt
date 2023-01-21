package com.example.ecommerce.presentation.navigation

sealed class Screen(val route: String) {
    object MainPageScreen : Screen("main_page_screen")
    object ShopScreen : Screen("shop_screen")
    object BagScreen : Screen("bag_screen")
    object ProfileScreen : Screen("profile_screen")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}