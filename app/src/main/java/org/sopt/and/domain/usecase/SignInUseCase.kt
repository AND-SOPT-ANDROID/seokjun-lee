package org.sopt.and.domain.usecase

import org.sopt.and.domain.entity.SignInResponse
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
) {
    suspend operator fun invoke(user: User): Result<SignInResponse> =
        signInRepository.signInUser(user).onFailure {
            return Result.failure(Throwable(MESSAGE_FAILURE))
        }

    companion object {
        private const val MESSAGE_FAILURE = "아이디 또는 비밀번호가 일치하지 않습니다."

    }

}