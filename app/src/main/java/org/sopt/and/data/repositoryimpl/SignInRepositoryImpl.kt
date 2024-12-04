package org.sopt.and.data.repositoryimpl

import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.data.mapper.toSignInRequest
import org.sopt.and.domain.entity.SignInResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SignInRepositoryImpl @Inject constructor(
    private val userDataSource: AuthDataSource
) : SignInRepository {

    override suspend fun signInUser(user: User): Result<SignInResponse> = runCatching {
        suspendCoroutine { continuation ->
            userDataSource.postSignIn(user.toSignInRequest()).enqueue(object :
                Callback<BaseResponse<SignInResponseDto>> {
                override fun onResponse(
                    call: Call<BaseResponse<SignInResponseDto>>,
                    response: Response<BaseResponse<SignInResponseDto>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.result?.token?.let {
                            continuation.resume(
                                SignInResponse(
                                    token = it,
                                    message = MESSAGE_SUCCESS
                                )
                            )
                        }
                    } else {
                        continuation.resume(
                            SignInResponse(
                                message = MESSAGE_FAILURE
                            )
                        )
                    }
                }

                override fun onFailure(
                    call: Call<BaseResponse<SignInResponseDto>>,
                    throwable: Throwable
                ) {
                    continuation.resumeWithException(throwable)
                }
            })
        }
    }

    companion object {
        private const val MESSAGE_SUCCESS = "로그인에 성공했습니다."
        private const val MESSAGE_FAILURE = "아이디 또는 비밀번호가 일치하지 않습니다."
    }

}