package org.sopt.and.data.remote

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignUpResponseDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {
    @POST("/user")
    fun signUp(
        @Body request: SignUpRequest
    ): Call<BaseResponse<SignUpResponseDto>>
}