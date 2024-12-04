package org.sopt.and.data.repositoryimpl

import org.sopt.and.R
import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.mapper.toSignUpRequest
import org.sopt.and.domain.entity.SignUpResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val userDataSource: AuthDataSource
) : SignUpRepository {

    override suspend fun registerUser(user: User): Result<SignUpResponse> = runCatching {
        val response = userDataSource.postSignUp(user.toSignUpRequest())
        response.result.userNumber.run {
            SignUpResponse(
                id = this,
                message = R.string.signup_toast_success
            )
        }
    }

    private fun getMessageByCode(code: String): Int =
        when (code) {
            "00" -> R.string.signup_toast_failure_id_exist
            "01" -> R.string.signup_toast_failure_out_of_range
            else -> R.string.signup_toast_failure_unknown
        }
}