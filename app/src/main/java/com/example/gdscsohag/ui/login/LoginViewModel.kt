package com.example.gdscsohag.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.usecase.LoginUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "LoginViewModel"

@HiltViewModel
class LoginViewModel @Inject constructor(private val useCase: LoginUseCase) :
    BaseViewModel<LoginUiState>(LoginUiState()) {

    private val _events = MutableSharedFlow<Boolean>()
    val events = _events.asSharedFlow()

    private val _email = MutableStateFlow("muhmmad.nabil.albadry@gmail.com")
    val email = _email.asStateFlow()
    private val _password = MutableStateFlow("123456789")
    val password = _password.asStateFlow()
    fun onClickLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true) }
            useCase(_email.value, _password.value).apply {
                _state.update {
                    it.copy(
                        isLoading = false,
                        loginResponse = data,
                        error = message

                    )
                }
            }
            //   _events.emit(true)
        }
    }

}