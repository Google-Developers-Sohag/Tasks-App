package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.domain.Task
import com.example.gdscsohag.ui.base.ContentStatus

data class TasksUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING,
    val tasks: List<Task> = listOf()
)