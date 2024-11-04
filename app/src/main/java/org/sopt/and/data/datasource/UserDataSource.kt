package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseSuccessResponse
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignUpResponseDto
import retrofit2.Call

interface UserDataSource {
    fun postSignUp(
        request: SignUpRequest
    ): Call<BaseSuccessResponse<SignUpResponseDto>>
}