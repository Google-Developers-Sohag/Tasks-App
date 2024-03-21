package com.example.gdscsohag.domain.repo

import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Session
import com.example.gdscsohag.domain.entity.Task
import com.example.gdscsohag.domain.entity.User

interface Repository {
    suspend fun login(email: String, pass: String): NetworkResponse<Boolean>
    suspend fun getAllProgress(): List<Progress>
    suspend fun getSessions(): NetworkResponse<List<Session>>
    suspend fun getAllTasks(): List<Task>
    suspend fun getAllTrainee(): List<User>
    suspend fun getTraineeByPoints():NetworkResponse<List<User>>
}