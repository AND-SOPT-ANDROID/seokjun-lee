package org.sopt.and.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequestDto(
    @SerialName("username")
    val userName: String,
    @SerialName("password")
    val password: String,
    @SerialName("hobby")
    val hobby: String
)
