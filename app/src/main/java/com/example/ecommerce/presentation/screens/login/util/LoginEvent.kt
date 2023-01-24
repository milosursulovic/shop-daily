package com.example.ecommerce.presentation.screens.login.util

sealed class LoginEvent {
    data class Login(val username: String, val password: String) : LoginEvent()
}