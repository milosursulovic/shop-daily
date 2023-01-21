package com.example.ecommerce.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.example.ecommerce.presentation.ui.theme.Success

@Composable
fun FeedbackLabel(
    feedbackType: FeedbackType
) {
    Text(
        text = feedbackType.msg,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = when (feedbackType) {
            is FeedbackType.Error -> MaterialTheme.colors.error
            is FeedbackType.Success -> Success
            is FeedbackType.Info -> Color.Blue
        }
    )
}