package org.sopt.and.data.remote

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/user")
    suspend fun signUp(
        @Body request: SignUpRequestDto
    ): BaseResponse<SignUpResponseDto>

    @POST("/login")
    suspend fun signIn(
        @Body request: SignInRequestDto
    ): BaseResponse<SignInResponseDto>
}