package com.example.gdscsohag.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T>(uiState: T) : ViewModel() {
    private val _state = MutableStateFlow(uiState)
    open val state = _state.asStateFlow()
}