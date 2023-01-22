package com.example.ecommerce.presentation.screens.login

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.components.button.CustomButton
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.screens.login.components.custom_login.ForgotPassword
import com.example.ecommerce.presentation.screens.login.components.custom_login.LoginTextField
import com.example.ecommerce.presentation.screens.login.components.social.SocialCard
import com.example.ecommerce.presentation.screens.login.util.custom_login.LoginFieldType
import com.example.ecommerce.presentation.screens.login.util.social.SocialType
import com.example.ecommerce.presentation.screens.main.MainActivity

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
            color = MaterialTheme.colors.onBackground,
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
            CustomButton(modifier = Modifier
                .fillMaxWidth(),
                textModifier = Modifier.padding(vertical = 10.dp),
                text = "LOGIN",
                onClick = {
                    context.startActivity(Intent(context, MainActivity::class.java))
                    (context as ComponentActivity).finish()
                })
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Or login with social account",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                SocialCard(SocialType.Google)
                Spacer(modifier = Modifier.width(30.dp))
                SocialCard(SocialType.Facebook)
            }
        }
    }
}