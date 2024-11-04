package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.data.mapper.toSignInRequest
import org.sopt.and.data.mapper.toSignUpRequest
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import org.sopt.and.domain.repository.SignUpRepository
import retrofit2.Call
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : SignInRepository {
    override fun signInUser(user: User): Call<BaseResponse<SignInResponseDto>> =
        userDataSource.postSignIn(user.toSignInRequest())


}