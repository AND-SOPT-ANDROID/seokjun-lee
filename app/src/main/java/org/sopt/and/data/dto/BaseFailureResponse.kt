package org.sopt.and.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseFailureResponse(
    @SerialName("code")
    val code: String
)