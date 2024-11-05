package org.sopt.and.data.datasourceImpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.MyHobbyResponseDto
import org.sopt.and.data.remote.UserService
import retrofit2.Call
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService
) : UserDataSource {
    override fun getMyHobby(token: String): Call<BaseResponse<MyHobbyResponseDto>> =
        userService.getMyHobby(token)
}