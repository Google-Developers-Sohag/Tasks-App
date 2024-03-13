package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.ui.base.BaseUiState

data class TasksUiState(
    val email: String = "",
    val password: String = ""
) : BaseUiState()