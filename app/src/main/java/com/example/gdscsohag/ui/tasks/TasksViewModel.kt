package com.example.gdscsohag.ui.tasks

import com.example.gdscsohag.domain.usecase.GetAllTasksUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase
) : BaseViewModel<TasksUiState>(TasksUiState()) {

    fun onClickTryAgain() {

    }
}