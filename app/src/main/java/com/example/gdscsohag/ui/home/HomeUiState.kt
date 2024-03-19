package com.example.gdscsohag.ui.home

import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.ui.base.ContentStatus

data class HomeUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING,
    val progressList: List<Progress> = listOf()
)