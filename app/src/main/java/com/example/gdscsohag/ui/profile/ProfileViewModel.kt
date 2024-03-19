package com.example.gdscsohag.ui.profile

import com.example.gdscsohag.domain.usecase.GetAllTraineesRanksUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getAllTraineesRanksUseCase: GetAllTraineesRanksUseCase
) : BaseViewModel<ProfileUiState>(ProfileUiState()) {

    fun onClickTryAgain() {

    }
}