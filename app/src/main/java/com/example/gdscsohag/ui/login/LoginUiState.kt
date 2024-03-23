package com.example.gdscsohag.ui.login

import com.example.gdscsohag.ui.base.ContentStatus

data class LoginUiState(
    val contentStatus: ContentStatus = ContentStatus.VISIBLE,
    val email: String = "",
    val password: String = "",
    val emailErrorMessage: String? = null,
    val passwordErrorMessage: String? = null,
)