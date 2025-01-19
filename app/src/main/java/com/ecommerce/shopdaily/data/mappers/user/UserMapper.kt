package com.ecommerce.shopdaily.data.mappers.user

import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import com.ecommerce.shopdaily.domain.model.login.User

fun User.toUserEntity(): UserEntity =
    UserEntity(
        username = username,
        email = email,
        firstName = firstName,
        lastName = lastName,
        image = image,
        token = token
    )

fun UserDto.toUser(): User = User(username, email, firstName, lastName, image, accessToken)

fun UserEntity.toUser(): User = User(username, email, firstName, lastName, image, token)