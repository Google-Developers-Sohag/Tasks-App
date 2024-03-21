package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.domain.repo.Repository
import javax.inject.Inject

class GetSessionsUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke() = repo.getSessions()
}