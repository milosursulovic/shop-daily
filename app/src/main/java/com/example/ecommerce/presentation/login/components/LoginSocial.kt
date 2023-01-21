package com.example.ecommerce.presentation.login.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.login.util.SocialType

@Composable
fun LoginSocial() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Or login with social account", style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            SocialCard(SocialType.Google)
            Spacer(modifier = Modifier.width(30.dp))
            SocialCard(SocialType.Facebook)
        }
    }
}