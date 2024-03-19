package com.example.gdscsohag.ui.profile

import com.example.gdscsohag.domain.entity.Trainee
import com.example.gdscsohag.ui.base.ContentStatus

data class ProfileUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING,
    val trainees: List<Trainee> = listOf()
)