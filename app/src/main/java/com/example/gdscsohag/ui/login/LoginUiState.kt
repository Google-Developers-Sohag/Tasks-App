package com.example.gdscsohag.ui.login

import com.example.gdscsohag.domain.entity.NetworkResponse

data class LoginUiState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val loginResponse: Boolean? = null
)