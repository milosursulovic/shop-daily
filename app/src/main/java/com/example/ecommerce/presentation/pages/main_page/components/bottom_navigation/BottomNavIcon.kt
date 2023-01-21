package com.example.ecommerce.presentation.pages.main_page.components.bottom_navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.pages.main_page.util.bottom_navigation.NavIcon
import com.example.ecommerce.presentation.ui.theme.Gray

@Composable
fun BottomNavIcon(
    navIcon: NavIcon
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { }) {
            Icon(
                navIcon.icon,
                null,
                modifier = Modifier.size(30.dp),
                tint = if (navIcon.label == "Home") MaterialTheme.colors.primary else Gray
            )
        }
        Text(
            text = navIcon.label,
            style = MaterialTheme.typography.h4,
            color = if (navIcon.label == "Home") MaterialTheme.colors.primary else Gray
        )
    }
}