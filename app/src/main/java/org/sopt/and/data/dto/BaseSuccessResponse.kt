package org.sopt.and.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
 data class  BaseSuccessResponse<T>(
    @SerialName("result")
    val result: T
)
