package org.sopt.and.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInRequestDto(
    @SerialName("username")
    val userName: String,
    @SerialName("password")
    val password: String
)
