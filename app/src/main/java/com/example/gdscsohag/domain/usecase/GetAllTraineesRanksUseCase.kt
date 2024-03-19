package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.data.Repository
import com.example.gdscsohag.domain.entity.Progress
import com.example.gdscsohag.domain.entity.Trainee
import javax.inject.Inject

class GetAllTraineesRanksUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Trainee> {
        return repository.getAllTrainee()
    }
}