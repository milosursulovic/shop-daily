package com.example.ecommerce.presentation.pages.login.util

sealed class SocialType {
    object Google : SocialType()
    object Facebook : SocialType()
}
