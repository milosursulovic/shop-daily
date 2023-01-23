package com.example.ecommerce.presentation.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce.common.Resource
import com.example.ecommerce.domain.use_cases.remote.LoginUseCase
import com.example.ecommerce.presentation.screens.login.util.LoginState
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    private var _loginState by mutableStateOf(LoginState())
    val loginState: LoginState = _loginState

    fun login() {
        viewModelScope.launch {
            loginUseCase().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _loginState = _loginState.copy(isLoading = true)
                    }
                    is Resource.Success -> {
                        result.data?.let { user ->
                            _loginState = _loginState.copy(
                                isLoading = false,
                                loggedUser = user
                            )
                        }
                    }
                    is Resource.Error -> {
                        result.message?.let { errorMessage ->
                            _loginState = _loginState.copy(
                                isLoading = false,
                                error = errorMessage
                            )
                        }
                    }
                }
            }
        }
    }
}