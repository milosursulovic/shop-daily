package com.example.ecommerce.presentation.pages.login

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.pages.login.components.custom_login.ForgotPassword
import com.example.ecommerce.presentation.pages.login.components.custom_login.LoginTextField
import com.example.ecommerce.presentation.pages.login.components.social.SocialCard
import com.example.ecommerce.presentation.pages.login.util.custom_login.LoginFieldType
import com.example.ecommerce.presentation.pages.login.util.social.SocialType
import com.example.ecommerce.presentation.pages.main.MainActivity

@Composable
fun Login() {
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
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
                Text(
                    text = "LOGIN",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontSize = 14.sp
                )
            }
        }
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
}