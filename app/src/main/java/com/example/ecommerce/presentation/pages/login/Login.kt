package com.example.ecommerce.presentation.pages.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.pages.login.components.custom_login.LoginInput
import com.example.ecommerce.presentation.pages.login.components.social.LoginSocial

@Composable
fun Login() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Start
        )
        LoginInput()
        LoginSocial()
    }
}