package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import retrofit2.Call

interface AuthDataSource {
    fun postSignUp(
        request: SignUpRequestDto
    ): Call<BaseResponse<SignUpResponseDto>>

    fun postSignIn(
        request: SignInRequestDto
    ): Call<BaseResponse<SignInResponseDto>>
}