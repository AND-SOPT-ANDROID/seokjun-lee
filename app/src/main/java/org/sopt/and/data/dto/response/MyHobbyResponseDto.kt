package org.sopt.and.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyHobbyResponseDto(
    @SerialName("hobby")
    val hobby: String
)
