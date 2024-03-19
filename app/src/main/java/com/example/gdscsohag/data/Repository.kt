package com.example.gdscsohag.data

import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.domain.entity.Trainee

interface Repository {
    suspend fun getAllProgress(): List<Progress>
    suspend fun getAllTasks(): List<Task>
    suspend fun getAllTrainee(): List<Trainee>
}