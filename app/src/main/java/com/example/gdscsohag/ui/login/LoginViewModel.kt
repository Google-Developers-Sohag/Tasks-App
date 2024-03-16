package com.example.gdscsohag.ui.login

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : BaseViewModel<LoginUiState>(LoginUiState()) {

    private val _events = MutableSharedFlow<Boolean>()
    val events = _events.asSharedFlow()
    fun onClickLogin() {
        viewModelScope.launch {
            _events.emit(true)
        }
    }

}