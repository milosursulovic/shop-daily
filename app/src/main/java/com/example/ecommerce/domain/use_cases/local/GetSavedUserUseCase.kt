package com.example.ecommerce.domain.use_cases.local

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.mappers.toUser
import com.example.ecommerce.domain.model.login.User
import com.example.ecommerce.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSavedUserUseCase(
    private val repository: DummyJsonRepository
) {
    suspend operator fun invoke(): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getSavedUser()[0].toUser()))
        } catch (e: Exception) {
            emit(Resource.Error("[ERROR]: ${e.localizedMessage}"))
        }
    }
}