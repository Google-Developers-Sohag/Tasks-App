package com.example.gdscsohag.domain.entity

data class Session(
    val startDate: String,
    val endDate: String,
    val sessionVideo: String,
    val tasks: List<Task>
) {
    data class Task(
        val points: Int,
        val content: String
    )
}
