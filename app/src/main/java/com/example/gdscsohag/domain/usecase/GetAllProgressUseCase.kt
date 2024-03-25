package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.domain.entity.NetworkResponse
import com.example.gdscsohag.domain.repo.Repository
import com.example.gdscsohag.domain.entity.Progress
import javax.inject.Inject

class GetAllProgressUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): NetworkResponse<List<Progress>> {
        return repository.getAllProgress()
    }
}