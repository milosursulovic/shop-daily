package com.ecommerce.shopdaily.presentation.screens.login.util.custom_login

sealed class LoginFieldType {
    object Email : LoginFieldType()
    object Password : LoginFieldType()
}