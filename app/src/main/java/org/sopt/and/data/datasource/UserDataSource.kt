package org.sopt.and.data.datasource

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.MyHobbyResponseDto
import retrofit2.Call

interface UserDataSource {
    fun getMyHobby(token: String): Call<BaseResponse<MyHobbyResponseDto>>
}