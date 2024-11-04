package org.sopt.and.data.mapper

import org.sopt.and.data.dto.request.SignUpRequest
import org.sopt.and.domain.entity.User

fun User.toSignUpRequest(): SignUpRequest = SignUpRequest(
    userName = this.userName,
    password = this.password,
    hobby = this.hobby
)