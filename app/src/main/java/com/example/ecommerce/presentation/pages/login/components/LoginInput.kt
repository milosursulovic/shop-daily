package com.example.ecommerce.presentation.pages.login.components

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.presentation.common.components.FeedbackLabel
import com.example.ecommerce.presentation.common.util.FeedbackType
import com.example.ecommerce.presentation.pages.login.util.LoginFieldType
import com.example.ecommerce.presentation.pages.main_page.MainActivity

@Composable
fun LoginInput() {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

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
        ForgotPassword()
        Spacer(modifier = Modifier.height(20.dp))
        FeedbackLabel(
            FeedbackType.Error("This is test error message")
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
                (context as ComponentActivity).finish()
            }, modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "LOGIN", modifier = Modifier.padding(vertical = 10.dp), fontSize = 14.sp)
        }
    }
}