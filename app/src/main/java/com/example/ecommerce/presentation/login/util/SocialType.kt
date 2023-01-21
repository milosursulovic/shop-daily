package com.example.ecommerce.presentation.login.util

sealed class SocialType {
    object Google : SocialType()
    object Facebook : SocialType()
}
