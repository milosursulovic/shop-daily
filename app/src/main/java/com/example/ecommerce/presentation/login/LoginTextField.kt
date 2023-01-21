package com.example.ecommerce.presentation.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.login.util.LoginFieldType
import com.example.ecommerce.presentation.ui.theme.Gray
import com.example.ecommerce.presentation.ui.theme.Success
import com.example.ecommerce.presentation.ui.theme.White

@Composable
fun LoginTextField(
    type: LoginFieldType,
    text: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        singleLine = true,
        value = text,
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            onValueChange(it)
        },
        trailingIcon = {
            if (type is LoginFieldType.Email && text.isNotEmpty()) {
                IconButton(onClick = { }) {
                    Icon(
                        Icons.Default.Check,
                        "Check",
                        modifier = Modifier.size(20.dp),
                        tint = Success
                    )
                }
            }
        },
        label = {
            when (type) {
                is LoginFieldType.Email -> Text(text = "Email")
                is LoginFieldType.Password -> Text(text = "Password")
            }
        },
        visualTransformation = if (type is LoginFieldType.Email) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = {
            when (type) {
                is LoginFieldType.Email -> Text(
                    text = "Email",
                    style = MaterialTheme.typography.body2
                )
                is LoginFieldType.Password -> Text(
                    text = "Password",
                    style = MaterialTheme.typography.body2
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = White,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            focusedLabelColor = Gray
        )
    )
}