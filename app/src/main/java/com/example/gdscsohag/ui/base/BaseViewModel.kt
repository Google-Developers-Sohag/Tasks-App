package com.example.gdscsohag.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T>(uiState: T) : ViewModel() {
    protected val _state = MutableStateFlow(uiState)
    val state = _state.asStateFlow()
}