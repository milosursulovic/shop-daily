package com.example.ecommerce.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.common.Resource
import com.example.ecommerce.domain.model.login.User
import com.example.ecommerce.domain.use_cases.local.GetSavedUserUseCase
import com.example.ecommerce.domain.use_cases.local.SaveUserUseCase
import com.example.ecommerce.domain.use_cases.remote.LoginUseCase
import com.example.ecommerce.presentation.screens.login.util.LoginEvent
import com.example.ecommerce.presentation.screens.login.util.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val saveUserUseCase: SaveUserUseCase,
    private val getSavedUserUseCase: GetSavedUserUseCase
) : ViewModel() {
    var loginState by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Login -> login(event.username, event.password)
            is LoginEvent.SaveUser -> saveUser(event.user)
            is LoginEvent.GetSavedUser -> getSavedUser()
        }
    }

    private fun login(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase(username, password).collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        loginState = loginState.copy(isLoading = true)
                    }
                    is Resource.Success -> {
                        result.data?.let { user ->
                            loginState = loginState.copy(
                                isLoading = false,
                                loggedUser = user
                            )
                        }
                    }
                    is Resource.Error -> {
                        result.message?.let { errorMessage ->
                            loginState = loginState.copy(
                                isLoading = false,
                                error = errorMessage
                            )
                        }
                    }
                }
            }
        }
    }

    private fun saveUser(user: User) {
        viewModelScope.launch {
            saveUserUseCase(user).collect { result ->
                when (result) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {}
                    is Resource.Error -> {}
                }
            }
        }
    }

    private fun getSavedUser() {
        viewModelScope.launch {
            getSavedUserUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {}
                    is Resource.Error -> {}
                }
            }
        }
    }
}