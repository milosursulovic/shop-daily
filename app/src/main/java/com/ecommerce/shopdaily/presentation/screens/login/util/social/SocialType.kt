package com.ecommerce.shopdaily.presentation.screens.login.util.social

sealed class SocialType {
    object Google : SocialType()
    object Facebook : SocialType()
}
