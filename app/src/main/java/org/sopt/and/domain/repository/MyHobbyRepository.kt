package org.sopt.and.domain.repository

import org.sopt.and.domain.entity.Hobby

interface MyHobbyRepository {
    suspend fun getMyHobby(token: String): Result<Hobby>
}