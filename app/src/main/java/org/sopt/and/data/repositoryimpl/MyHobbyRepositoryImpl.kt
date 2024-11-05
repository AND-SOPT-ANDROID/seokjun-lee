package org.sopt.and.data.repositoryimpl

import android.util.Log
import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.MyHobbyResponseDto
import org.sopt.and.domain.entity.Hobby
import org.sopt.and.domain.repository.MyHobbyRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class MyHobbyRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : MyHobbyRepository {
    override suspend fun getMyHobby(token: String): Result<Hobby> = runCatching {
        suspendCoroutine { continuation ->
            userDataSource.getMyHobby(token)
                .enqueue(object : Callback<BaseResponse<MyHobbyResponseDto>> {
                    override fun onResponse(
                        call: Call<BaseResponse<MyHobbyResponseDto>>,
                        response: Response<BaseResponse<MyHobbyResponseDto>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.result?.hobby?.let {
                                val hobby = Hobby(it)
                                Log.d("MyHobby", it)
                                continuation.resume(hobby)
                            }
                        } else {
                            continuation.resumeWithException(Exception())
                        }
                    }

                    override fun onFailure(
                        call: Call<BaseResponse<MyHobbyResponseDto>>,
                        response: Throwable
                    ) {
                        Log.d("MyHobby", "fail")
                        continuation.resumeWithException(response)
                    }
                })
        }
    }

}