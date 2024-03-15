package com.example.gdscsohag.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel(uiState: BaseUiState) : ViewModel() {
    private val _state = MutableStateFlow(uiState)
    open val state = _state.asStateFlow()
}