package org.sopt.and.domain.repository

import org.sopt.and.data.dto.BaseSuccessResponse
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.domain.entity.User
import retrofit2.Call

interface SignUpRepository {
    fun registerUser(user: User): Call<BaseSuccessResponse<SignUpResponseDto>>
}