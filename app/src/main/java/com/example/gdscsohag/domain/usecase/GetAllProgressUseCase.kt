package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.domain.repo.Repository
import com.example.gdscsohag.domain.entity.Progress
import javax.inject.Inject

class GetAllProgressUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Progress> {
        return repository.getAllProgress()
    }
}