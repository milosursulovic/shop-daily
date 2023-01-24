package com.example.ecommerce.presentation.screens.login

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.ecommerce.presentation.common.components.button.CustomButton
import com.example.ecommerce.presentation.common.components.feedback.FeedbackLabel
import com.example.ecommerce.presentation.common.components.screen.ScreenTitle
import com.example.ecommerce.presentation.common.util.feedback.FeedbackType
import com.example.ecommerce.presentation.screens.login.components.custom_login.ForgotPassword
import com.example.ecommerce.presentation.screens.login.components.custom_login.LoginTextField
import com.example.ecommerce.presentation.screens.login.components.social.SocialCard
import com.example.ecommerce.presentation.screens.login.util.LoginEvent
import com.example.ecommerce.presentation.screens.login.util.custom_login.LoginFieldType
import com.example.ecommerce.presentation.screens.login.util.social.SocialType
import com.example.ecommerce.presentation.screens.main.MainActivity

@Composable
fun Login(viewModel: LoginViewModel) {
    val loginState = viewModel.loginState
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
        ScreenTitle(
            title = "Login", modifier = Modifier
                .padding(start = 20.dp)
        )
        loginState.loggedUser?.let {
            context.startActivity(Intent(context, MainActivity::class.java))
            (context as ComponentActivity).finish()

            //write user to db

        }
        if (loginState.isLoading) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
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
                loginState.error?.let {
                    FeedbackLabel(
                        FeedbackType.Error(it)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomButton(modifier = Modifier
                    .fillMaxWidth(),
                    textModifier = Modifier.padding(vertical = 10.dp),
                    text = "LOGIN",
                    onClick = {
                        viewModel.onEvent(LoginEvent.Login(emailState, passwordState))
                    })
            }
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