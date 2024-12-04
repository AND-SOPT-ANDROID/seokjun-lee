package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.mapper.toSignInRequest
import org.sopt.and.domain.entity.SignInResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val userDataSource: AuthDataSource
) : SignInRepository {

    override suspend fun signInUser(user: User): Result<SignInResponse> = runCatching {
        val response = userDataSource.postSignIn(user.toSignInRequest())

        response.result.token.run {
            SignInResponse(
                token = this,
                message = MESSAGE_SUCCESS
            )
        }
    }

    companion object {
        private const val MESSAGE_SUCCESS = "로그인에 성공했습니다."
        private const val MESSAGE_FAILURE = "아이디 또는 비밀번호가 일치하지 않습니다."
    }

}