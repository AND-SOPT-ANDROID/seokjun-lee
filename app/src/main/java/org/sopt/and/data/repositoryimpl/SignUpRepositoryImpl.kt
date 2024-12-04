package org.sopt.and.data.repositoryimpl

import org.json.JSONObject
import org.sopt.and.R
import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignUpResponseDto
import org.sopt.and.data.mapper.toSignUpRequest
import org.sopt.and.domain.entity.SignUpResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignUpRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SignUpRepositoryImpl @Inject constructor(
    private val userDataSource: AuthDataSource
) : SignUpRepository {

    override suspend fun registerUser(user: User): Result<SignUpResponse> = runCatching {
        suspendCoroutine { continuation ->
            userDataSource.postSignUp(user.toSignUpRequest()).enqueue(object :
                Callback<BaseResponse<SignUpResponseDto>> {
                override fun onResponse(
                    call: Call<BaseResponse<SignUpResponseDto>>,
                    response: Response<BaseResponse<SignUpResponseDto>>
                ) {
                    if (response.isSuccessful) {
                        val userId = response.body()?.result?.userNumber
                        continuation.resume(
                            SignUpResponse(
                                id = userId,
                                message = R.string.signup_toast_success)
                        )
                    } else {
                        val code = response.errorBody()?.string()?.let { JSONObject(it) }?.getString("code").toString()
                        continuation.resume(
                            SignUpResponse(message = getMessageByCode(code))
                        )
                    }
                }

                override fun onFailure(
                    call: Call<BaseResponse<SignUpResponseDto>>,
                    throwable: Throwable
                ) {
                    continuation.resumeWithException(throwable)
                }
            })
        }
    }

    private fun getMessageByCode(code: String): Int =
        when (code) {
            "00" -> R.string.signup_toast_failure_id_exist
            "01" -> R.string.signup_toast_failure_out_of_range
            else -> R.string.signup_toast_failure_unknown
        }
}