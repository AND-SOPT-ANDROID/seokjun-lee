package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto

interface AuthDataSource {

    suspend fun postSignUp(
        request: SignUpRequestDto
    ): BaseResponse<SignUpResponseDto>

    suspend fun postSignIn(
        request: SignInRequestDto
    ): BaseResponse<SignInResponseDto>
}