package com.ecommerce.shopdaily.presentation.screens.login.util

import com.ecommerce.shopdaily.domain.model.login.User

sealed class LoginEvent {
    data class Login(val username: String, val password: String) : LoginEvent()
    data class SaveUser(val user: User) : LoginEvent()
    object GetSavedUser : LoginEvent()
}