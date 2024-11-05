package org.sopt.and.domain.repository

import org.sopt.and.domain.entity.SignInResponse
import org.sopt.and.domain.entity.User

interface SignInRepository {
    suspend fun signInUser(user: User): Result<SignInResponse>
}