package com.example.ecommerce.presentation.login

sealed class SocialType {
    object Google : SocialType()
    object Facebook : SocialType()
}
