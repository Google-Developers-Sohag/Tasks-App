package com.example.gdscsohag.data

import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.domain.entity.Trainee
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    override suspend fun getAllProgress(): List<Progress> {
        return listOf()
    }

    override suspend fun getAllTasks(): List<Task> {
        return listOf()
    }

    override suspend fun getAllTrainee(): List<Trainee> {
        return listOf()
    }
}