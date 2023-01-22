package com.example.ecommerce.presentation.screens.login.components.social

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ecommerce.R
import com.example.ecommerce.presentation.screens.login.util.social.SocialType

@Composable
fun SocialCard(
    socialType: SocialType
) {
    Card(
        elevation = 10.dp, shape = RoundedCornerShape(30.dp), modifier = Modifier
            .width(100.dp)
            .height(80.dp)
    ) {
        IconButton(modifier = Modifier.fillMaxSize(), onClick = { }) {
            Icon(
                painter = when (socialType) {
                    is SocialType.Google -> painterResource(id = R.drawable.ic_google)
                    is SocialType.Facebook -> painterResource(id = R.drawable.ic_facebook)
                },
                null,
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified
            )
        }
    }
}