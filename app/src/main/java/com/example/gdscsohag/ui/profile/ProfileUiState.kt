package com.example.gdscsohag.ui.profile

import com.example.gdscsohag.ui.base.BaseUiState

data class ProfileUiState(
    val email: String = "",
    val password: String = ""
) : BaseUiState()