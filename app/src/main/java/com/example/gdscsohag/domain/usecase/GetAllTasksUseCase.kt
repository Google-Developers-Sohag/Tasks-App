package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.data.Repository
import com.example.gdscsohag.domain.entity.Task
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Task> {
        return repository.getAllTasks()
    }
}