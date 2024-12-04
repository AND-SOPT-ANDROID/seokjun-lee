package org.sopt.and.domain.repository

import org.sopt.and.domain.entity.SignUpResponse
import org.sopt.and.domain.entity.User

interface SignUpRepository {
    suspend fun registerUser(user: User): Result<SignUpResponse>
}