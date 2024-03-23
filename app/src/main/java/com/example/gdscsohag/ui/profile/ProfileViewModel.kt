package com.example.gdscsohag.ui.profile

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.entity.User
import com.example.gdscsohag.domain.usecase.GetTraineeByPointsUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getTraineeByPointsUseCase: GetTraineeByPointsUseCase
) : BaseViewModel<ProfileUiState>(ProfileUiState()) {

    init {
        getTrainee()
    }

    fun getTrainee() {
        _state.update { it.copy(contentStatus = ContentStatus.LOADING) }
        viewModelScope.launch {
            val data = getTraineeByPointsUseCase().data
            if (data != null) onTraineeSuccess(data) else onTraineeError()
        }
    }

    private fun onTraineeSuccess(success: List<User>) {
        _state.update {
            it.copy(
                contentStatus = ContentStatus.LOADING,
                trainees = success
            )
        }
    }

    private fun onTraineeError() {
        _state.update { it.copy(contentStatus = ContentStatus.ERROR) }
    }
}