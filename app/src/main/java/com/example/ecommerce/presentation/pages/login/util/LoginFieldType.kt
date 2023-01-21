package com.example.ecommerce.presentation.pages.login.util

sealed class LoginFieldType {
    object Email : LoginFieldType()
    object Password : LoginFieldType()
}