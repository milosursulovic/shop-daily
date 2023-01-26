package com.ecommerce.shopdaily.presentation.common.components.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.ecommerce.shopdaily.presentation.common.util.feedback.FeedbackType
import com.ecommerce.shopdaily.presentation.ui.theme.Success

@Composable
fun FeedbackLabel(
    modifier: Modifier = Modifier,
    feedbackType: FeedbackType
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
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
}