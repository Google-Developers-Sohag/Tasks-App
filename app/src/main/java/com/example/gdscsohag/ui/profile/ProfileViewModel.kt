package com.example.gdscsohag.ui.profile

import com.example.gdscsohag.domain.usecase.GetAllTraineesRanksUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getAllTraineesRanksUseCase: GetAllTraineesRanksUseCase
) : BaseViewModel<ProfileUiState>(ProfileUiState()) {

    fun onClickTryAgain() {

    }
}