package com.ecommerce.shopdaily.presentation.screens.login.components.social

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ecommerce.shopdaily.R
import com.ecommerce.shopdaily.presentation.screens.login.util.social.SocialType

@Composable
fun SocialCard(
    socialType: SocialType
) {
    Card(
        elevation = 10.dp, shape = RoundedCornerShape(30.dp), modifier = Modifier
            .width(100.dp)
            .height(80.dp)
    ) {
        IconButton(modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary), onClick = { }) {
            Icon(
                painter = painterResource(
                    id = when (socialType) {
                        is SocialType.Google -> R.drawable.ic_google
                        is SocialType.Facebook -> R.drawable.ic_facebook
                    }
                ),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color.Unspecified,
            )
        }
    }
}