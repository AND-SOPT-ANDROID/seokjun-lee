package org.sopt.and.domain.usecase

import org.sopt.and.domain.entity.SignUpResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
) {
    suspend operator fun invoke(user: User): Result<SignUpResponse> =
        signUpRepository.registerUser(user).onFailure { throwable ->
            val message1 = throwable.message?.split(" ")?.get(1)
            return Result.failure(Throwable(getMessageByCode(message1)))
        }

    private fun getMessageByCode(code: String?): String =
        when (code) {
            "400" -> "모든 입력은 8자 이하여야 합니다."
            "409" -> "이미 존재하는 아이디입니다."
            else -> "회원가입에 실패하였습니다."
        }
}