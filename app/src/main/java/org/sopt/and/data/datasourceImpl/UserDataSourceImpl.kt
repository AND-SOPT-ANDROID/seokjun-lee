package org.sopt.and.data.datasourceImpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.MyHobbyResponseDto
import org.sopt.and.data.remote.UserService
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
    private val userService: UserService
) : UserDataSource {

    override suspend fun getMyHobby(token: String): BaseResponse<MyHobbyResponseDto> =
        userService.getMyHobby(token)
}