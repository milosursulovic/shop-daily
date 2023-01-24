package com.example.ecommerce.domain.repository

import com.example.ecommerce.data.db.entities.UserEntity
import com.example.ecommerce.data.remote.dto.login.UserDto
import retrofit2.Response

interface DummyJsonRepository {
    suspend fun login(username: String, password: String): Response<UserDto>
    suspend fun getSavedUser(): List<UserEntity>
    suspend fun saveUser(user: UserEntity): Long
}