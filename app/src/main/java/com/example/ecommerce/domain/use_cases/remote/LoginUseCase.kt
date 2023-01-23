package com.example.ecommerce.domain.use_cases.remote

import com.example.ecommerce.common.Resource
import com.example.ecommerce.data.mappers.remote.login.toUser
import com.example.ecommerce.domain.model.login.User
import com.example.ecommerce.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginUseCase(private val repository: DummyJsonRepository) {
    suspend operator fun invoke(): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val response = repository.login()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it.toUser()))
                }
            } else {
                emit(Resource.Error("Something went wrong!"))
            }
        } catch (e: Exception) {
            emit(Resource.Error("[ERROR]: ${e.localizedMessage}"))
        }
    }
}