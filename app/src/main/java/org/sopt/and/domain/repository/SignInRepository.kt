package org.sopt.and.domain.repository

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.domain.entity.User
import retrofit2.Call

interface SignInRepository {
    fun signInUser(user: User): Call<BaseResponse<SignInResponseDto>>
}