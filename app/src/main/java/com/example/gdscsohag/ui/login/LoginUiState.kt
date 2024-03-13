package com.example.gdscsohag.ui.login

import com.example.gdscsohag.ui.base.BaseUiState

data class LoginUiState(
    val email: String = "",
    val password: String = ""
) : BaseUiState()