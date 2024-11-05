package org.sopt.and.domain.entity

import androidx.annotation.StringRes

data class SignUpResponse(
    val id: Int? = null,
    @StringRes val message: Int
)