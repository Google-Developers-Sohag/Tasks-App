package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.domain.repo.Repository
import com.example.gdscsohag.domain.entity.User
import javax.inject.Inject

class GetAllTraineesRanksUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<User> {
        return repository.getAllTrainee()
    }
}