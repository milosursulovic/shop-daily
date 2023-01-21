package com.example.ecommerce.presentation.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object MainPageScreen : Screen("main_page_screen")

    fun withArgs(vararg args: String): String = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}