package com.example.gdscsohag.ui.tasks

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.domain.usecase.GetSessionsUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase
) : BaseViewModel<TasksUiState>(TasksUiState()) {

    init {
        getSessions()
    }

    fun getSessions() {
        _state.update { it.copy(contentStatus = ContentStatus.LOADING) }
        viewModelScope.launch(Dispatchers.IO) {
            getSessionsUseCase().apply {
                if (data != null)
                    onSessionSuccess(data)
                else
                    onSessionError()

            }
        }
    }

    private fun onSessionSuccess(success: List<Session>) {
        _state.update {
            it.copy(
                contentStatus = ContentStatus.VISIBLE,
                sessions = success
            )
        }
    }


    private fun onSessionError() {
        _state.update { it.copy(contentStatus = ContentStatus.ERROR) }
    }
}