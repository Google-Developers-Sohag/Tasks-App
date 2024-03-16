package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.domain.Task

data class TasksUiState(
    val tasks: List<Task> = listOf()
)