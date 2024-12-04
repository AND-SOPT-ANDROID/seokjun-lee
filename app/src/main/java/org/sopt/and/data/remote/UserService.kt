package org.sopt.and.data.remote

import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.MyHobbyResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("/user/my-hobby")
    fun getMyHobby(
        @Header("token") token: String
    ): Call<BaseResponse<MyHobbyResponseDto>>
}