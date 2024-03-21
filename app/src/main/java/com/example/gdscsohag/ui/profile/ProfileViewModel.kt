package com.example.gdscsohag.ui.profile

import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.usecase.GetAllTraineesRanksUseCase
import com.example.gdscsohag.domain.usecase.GetTraineeByPointsUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAllTraineesRanksUseCase: GetAllTraineesRanksUseCase,
    private val getTraineeByPointsUseCase: GetTraineeByPointsUseCase
) : BaseViewModel<ProfileUiState>(ProfileUiState()) {

    fun getTrainee(){
        viewModelScope.launch {
            _state.update { it.copy(contentStatus = ContentStatus.LOADING) }
            getTraineeByPointsUseCase().apply {

            }
        }
    }

    fun onClickTryAgain() {

    }
}