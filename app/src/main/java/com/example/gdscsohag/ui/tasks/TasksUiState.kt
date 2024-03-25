package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.ui.base.ContentStatus

data class TasksUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING,
    val sessions: List<Session> = listOf()
)