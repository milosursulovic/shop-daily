package com.ecommerce.shopdaily.domain.use_cases.local

import com.ecommerce.shopdaily.common.Resource
import com.ecommerce.shopdaily.data.mappers.user.toUser
import com.ecommerce.shopdaily.domain.model.login.User
import com.ecommerce.shopdaily.domain.repository.DummyJsonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSavedUserUseCase(
    private val repository: DummyJsonRepository
) {
    operator fun invoke(): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            if (repository.getSavedUser().isNotEmpty()) {
                emit(Resource.Success(repository.getSavedUser()[0].toUser()))
            } else {
                emit(Resource.Error(""))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}