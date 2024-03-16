package com.example.gdscsohag.ui.base

open class BaseUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING
) {
    enum class ContentStatus {
        LOADING,
        VISIBLE,
        ERROR
    }
}