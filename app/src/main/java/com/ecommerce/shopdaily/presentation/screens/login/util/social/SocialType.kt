package com.ecommerce.shopdaily.presentation.screens.login.util.social

sealed class SocialType {
    data object Google : SocialType()
    data object Facebook : SocialType()
}
