package com.example.ecommerce.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.presentation.common.FeedbackLabel
import com.example.ecommerce.presentation.common.FeedbackType
import com.example.ecommerce.presentation.login.util.LoginFieldType

@Composable
fun LoginInput() {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTextField(type = LoginFieldType.Email, text = emailState) {
            emailState = it
        }
        Spacer(modifier = Modifier.height(20.dp))
        LoginTextField(type = LoginFieldType.Password, text = passwordState) {
            passwordState = it
        }
        Spacer(modifier = Modifier.height(20.dp))
        FeedbackLabel(
            FeedbackType.Error("This is test error message")
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "LOGIN", modifier = Modifier.padding(vertical = 10.dp), fontSize = 14.sp)
        }
    }
}