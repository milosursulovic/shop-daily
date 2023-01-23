package com.example.ecommerce.presentation.screens.main.profile.util

data class ProfileItem(
    val title: String,
    val subtitle: String
)

val profileItems = listOf(
    ProfileItem(
        title = "My orders",
        subtitle = "Already have 12 orders"
    ),
    ProfileItem(
        title = "Shipping addresses",
        subtitle = "3 addresses"
    ),
    ProfileItem(
        title = "Payment methods",
        subtitle = "Visa **34"
    ),
    ProfileItem(
        title = "Promocodes",
        subtitle = "You have special promocodes"
    ),
    ProfileItem(
        title = "My reviews",
        subtitle = "Reviews for 4 items"
    ),
    ProfileItem(
        title = "Settings",
        subtitle = "Notifications, password"
    )
)
