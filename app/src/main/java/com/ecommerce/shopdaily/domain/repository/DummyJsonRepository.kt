package com.ecommerce.shopdaily.domain.repository

import com.ecommerce.shopdaily.data.db.entities.UserEntity
import com.ecommerce.shopdaily.data.remote.dto.login.UserDto
import retrofit2.Response

interface DummyJsonRepository {
    suspend fun login(username: String, password: String): Response<UserDto>
    suspend fun getSavedUser(): List<UserEntity>
    suspend fun saveUser(user: UserEntity): Long
}