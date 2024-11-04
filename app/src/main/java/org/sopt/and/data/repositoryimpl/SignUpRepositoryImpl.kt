package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.data.mapper.toSignUpRequest
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignUpRepository
import retrofit2.Call
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
): SignUpRepository {
    override fun registerUser(user: User): Call<BaseResponse<SignUpResponseDto>> = userDataSource.postSignUp(user.toSignUpRequest())

}