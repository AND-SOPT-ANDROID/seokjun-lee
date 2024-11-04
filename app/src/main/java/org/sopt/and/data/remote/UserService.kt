package org.sopt.and.data.remote

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/user")
    fun signUp(
        @Body request: SignUpRequestDto
    ): Call<BaseResponse<SignUpResponseDto>>

    @POST("/login")
    fun signIn(
        @Body request: SignInRequestDto
    ): Call<BaseResponse<SignInResponseDto>>
}