package com.example.gdscsohag.ui.tasks

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.usecase.GetAllTasksUseCase
import com.example.gdscsohag.domain.usecase.GetSessionsUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "TasksViewModel"

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase,
    private val getAllTasksUseCase: GetAllTasksUseCase
) : BaseViewModel<TasksUiState>(TasksUiState()) {

    fun getSessions() {
        viewModelScope.launch {
            _state.update { it.copy(contentStatus = ContentStatus.LOADING) }
            getSessionsUseCase().apply {
                if (data != null) _state.update {
                    it.copy(
                        contentStatus = ContentStatus.VISIBLE,
                        sessions = data
                    )
                }
            }
        }
    }

    fun onClickTryAgain() {

    }
}