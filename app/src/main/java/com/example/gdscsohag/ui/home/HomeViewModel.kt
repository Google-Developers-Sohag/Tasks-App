package com.example.gdscsohag.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.gdscsohag.domain.usecase.GetAllProgressUseCase
import com.example.gdscsohag.ui.base.BaseViewModel
import com.example.gdscsohag.ui.base.ContentStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProgressUseCase: GetAllProgressUseCase
) : BaseViewModel<HomeUiState>(HomeUiState()) {

    fun onClickTryAgain() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllProgressUseCase().apply {
                Log.i(TAG,data.toString())
                _state.update {
                    it.copy(
                        contentStatus = ContentStatus.VISIBLE,
                        progressList = data!!
                    )
                }
            }
        }
    }
}