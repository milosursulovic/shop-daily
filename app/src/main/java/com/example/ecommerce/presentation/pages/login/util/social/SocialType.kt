package com.example.ecommerce.presentation.pages.login.util.social

sealed class SocialType {
    object Google : SocialType()
    object Facebook : SocialType()
}
