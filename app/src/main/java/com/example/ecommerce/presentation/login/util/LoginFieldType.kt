package com.example.ecommerce.presentation.login.util

sealed class LoginFieldType {
    object Email : LoginFieldType()
    object Password : LoginFieldType()
}