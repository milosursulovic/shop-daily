package com.example.ecommerce.data.mappers.remote.login

import com.example.ecommerce.data.remote.dto.login.UserDto
import com.example.ecommerce.domain.model.login.User

fun UserDto.toUser(): User = User(email, firstName, lastName, image, token)