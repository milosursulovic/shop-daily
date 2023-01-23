package com.example.ecommerce.data.repository

import com.example.ecommerce.data.remote.DummyJsonService
import com.example.ecommerce.data.remote.dto.login.UserDto
import com.example.ecommerce.domain.repository.DummyJsonRepository
import retrofit2.Response

class DummyJsonRepositoryImpl(private val api: DummyJsonService) : DummyJsonRepository {
    override suspend fun login(): Response<UserDto> = api.login()
}