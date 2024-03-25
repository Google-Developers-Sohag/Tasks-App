package com.example.gdscsohag.ui.login

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.data.SharedPrefManager
import com.example.gdscsohag.domain.usecase.LoginUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState>(LoginUiState()) {

    private val _events = MutableSharedFlow<Boolean>()
    val events = _events.asSharedFlow()
    fun onEmailChange(email: CharSequence) {
        _state.update { it.copy(email = email.toString()) }
    }

    fun onPasswordChange(password: CharSequence) {
        _state.update { it.copy(password = password.toString()) }
    }

    fun onClickLogin() {
        if (validateFields()) {
            _state.update { it.copy(contentStatus = ContentStatus.LOADING) }
            viewModelScope.launch(Dispatchers.IO) {
                val isSuccess = loginUseCase(state.value.email, state.value.password).data
                if (isSuccess != null)
                    onLoginSuccess()
                else
                    onLoginError()
            }
        }
    }

    private fun onLoginSuccess() {
        SharedPrefManager.isLogin = true
        viewModelScope.launch { _events.emit(true) }
    }


    private fun onLoginError() {
        _state.update { it.copy(contentStatus = ContentStatus.VISIBLE) }
        viewModelScope.launch { _events.emit(false) }
    }

    private fun validateFields(): Boolean {
        val validation = listOf(state.value.email.isBlank(), state.value.password.isBlank())
        _state.update { value ->
            value.copy(
                emailErrorMessage = if (value.email.isBlank()) "" else null,
                passwordErrorMessage = if (value.password.isBlank()) "" else null
            )
        }
        return !validation.contains(true)
    }

}