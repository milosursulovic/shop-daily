package com.ecommerce.shopdaily.presentation.screens.login.util

import com.ecommerce.shopdaily.domain.model.login.User

data class LoginState(
    val isLoading: Boolean = false,
    val loggedUser: User? = null,
    val savedUser: User? = null,
    val error: String? = null
)