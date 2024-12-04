package org.sopt.and.domain.entity

data class SignInResponse(
    val token: String? = null,
    val message: String = "" ,
)