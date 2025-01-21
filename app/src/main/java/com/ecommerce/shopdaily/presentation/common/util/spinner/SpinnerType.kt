package com.ecommerce.shopdaily.presentation.common.util.spinner

sealed class SpinnerType {
    data object Size : SpinnerType()
    data object Color : SpinnerType()
}
