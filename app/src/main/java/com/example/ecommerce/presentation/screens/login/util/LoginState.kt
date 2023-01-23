package com.example.ecommerce.presentation.screens.login.util

import com.example.ecommerce.domain.model.login.User

data class LoginState(
    val isLoading: Boolean = false,
    val loggedUser: User? = null,
    val error: String? = null
)