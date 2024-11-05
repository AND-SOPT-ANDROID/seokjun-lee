package org.sopt.and.domain.entity

import androidx.annotation.StringRes

data class SignInResponse(
    val token: String? = null,
    @StringRes val message: Int
)