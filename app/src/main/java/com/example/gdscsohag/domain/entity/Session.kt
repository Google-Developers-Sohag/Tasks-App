package com.example.gdscsohag.domain.entity

data class Session(
    val startDate: String,
    val endDate: String,
    val sessionVideo: String,
    val tasks: List<String>
)