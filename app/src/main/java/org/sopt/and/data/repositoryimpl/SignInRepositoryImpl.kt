package org.sopt.and.data.repositoryimpl

import android.util.Log
import org.json.JSONObject
import org.sopt.and.R
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
                                    message = R.string.signin_snackbar_success
                                )
                            )
                        }
                    } else {
                        response.errorBody()?.run {
                            val body = JSONObject(string())
                            Log.d("SignIn", "code : ${body.getString("code")}")
                        }
                        continuation.resume(
                            SignInResponse(
                                message = R.string.signin_snackbar_fail
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
}