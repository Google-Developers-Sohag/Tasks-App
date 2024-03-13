package com.example.gdscsohag.ui.home

import com.example.gdscsohag.ui.base.BaseUiState

data class HomeUiState(
    val email: String = "",
    val password: String = ""
) : BaseUiState()