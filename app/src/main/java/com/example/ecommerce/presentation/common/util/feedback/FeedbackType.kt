package com.example.ecommerce.presentation.common.util.feedback

sealed class FeedbackType(val msg: String) {
    data class Error(val errorMsg: String) : FeedbackType(errorMsg)
    data class Info(val infoMsg: String) : FeedbackType(infoMsg)
    data class Success(val successMsg: String) : FeedbackType(successMsg)
}