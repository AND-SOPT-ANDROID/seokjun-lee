package org.sopt.and.data.mapper

import org.sopt.and.data.dto.request.SignInRequestDto
import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.domain.entity.User

fun User.toSignInRequest(): SignInRequestDto = SignInRequestDto(
    userName = this.userName,
    password = this.password
)