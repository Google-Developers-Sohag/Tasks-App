package com.example.gdscsohag.ui.home

import com.example.gdscsohag.domain.usecase.GetAllProgressUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProgressUseCase: GetAllProgressUseCase
) : BaseViewModel<HomeUiState>(HomeUiState()) {

    fun onClickTryAgain() {

    }
}