package com.example.ecommerce.presentation.common.components.spinner

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.util.spinner.SpinnerType
import com.example.ecommerce.presentation.ui.theme.Black
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun CustomSpinner(spinnerType: SpinnerType) {
    Row(
        modifier = Modifier
            .border(
                width = 1.dp, color = when (spinnerType) {
                    is SpinnerType.Size -> MaterialTheme.colors.primary
                    is SpinnerType.Color -> Gray
                }
            )
            .padding(vertical = 10.dp, horizontal = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = when (spinnerType) {
                is SpinnerType.Size -> "Size"
                is SpinnerType.Color -> "Color"
            },
            color = Black
        )
        Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Black)
    }
}