package com.example.gdscsohag.ui.home

import com.example.gdscsohag.domain.Progress
import com.example.gdscsohag.ui.base.BaseUiState

data class HomeUiState(
    val progressList: List<Progress> = listOf()
) : BaseUiState()