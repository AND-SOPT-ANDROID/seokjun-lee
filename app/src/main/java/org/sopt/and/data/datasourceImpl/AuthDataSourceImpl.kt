package org.sopt.and.data.datasourceImpl

import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.data.remote.AuthService
import retrofit2.Call
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val userService: AuthService
): AuthDataSource {
    override fun postSignUp(request: SignUpRequestDto): Call<BaseResponse<SignUpResponseDto>> = userService.signUp(request)
    override fun postSignIn(request: SignInRequestDto): Call<BaseResponse<SignInResponseDto>> = userService.signIn(request)
}