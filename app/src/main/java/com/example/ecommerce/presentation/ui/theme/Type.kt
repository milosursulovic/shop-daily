package com.example.ecommerce.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R

val Metrophobic = FontFamily(Font(R.font.metrophobic_regular, FontWeight.Bold))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    h2 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    h4 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),
    body1 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Metrophobic,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
)