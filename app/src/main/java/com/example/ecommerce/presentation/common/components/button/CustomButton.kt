package com.example.ecommerce.presentation.common.components.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier,
    textModifier: Modifier,
    text: String
) {
    Button(
        onClick = {
            onClick()
        }, modifier = modifier,
        shape = RoundedCornerShape(30.dp)
    ) {
        Text(
            text = text,
            modifier = textModifier,
            fontSize = 14.sp
        )
    }
}