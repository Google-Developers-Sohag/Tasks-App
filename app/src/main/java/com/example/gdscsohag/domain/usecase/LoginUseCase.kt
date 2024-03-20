package com.example.gdscsohag.domain.usecase

import com.example.gdscsohag.domain.repo.Repository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke(email: String, pass: String) = repo.login(email, pass)
}