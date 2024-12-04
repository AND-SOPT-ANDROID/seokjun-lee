package org.sopt.and.data.mapper

import org.sopt.and.data.dto.request.SignUpRequestDto
import org.sopt.and.domain.entity.User

fun User.toSignUpRequest(): SignUpRequestDto = SignUpRequestDto(
    userName = this.userName,
    password = this.password,
    hobby = this.hobby
)