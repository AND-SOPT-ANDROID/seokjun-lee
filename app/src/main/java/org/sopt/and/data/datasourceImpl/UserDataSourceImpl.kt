package org.sopt.and.data.datasourceImpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.data.remote.UserService
import retrofit2.Call
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService
): UserDataSource {
    override fun postSignUp(request: SignUpRequest): Call<BaseResponse<SignUpResponseDto>> = userService.signUp(request)
}