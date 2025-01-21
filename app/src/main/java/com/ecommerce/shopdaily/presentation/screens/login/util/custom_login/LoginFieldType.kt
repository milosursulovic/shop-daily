package com.ecommerce.shopdaily.presentation.screens.login.util.custom_login

sealed class LoginFieldType {
    data object Email : LoginFieldType()
    data object Password : LoginFieldType()
}