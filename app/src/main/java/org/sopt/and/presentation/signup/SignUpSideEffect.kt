package org.sopt.and.presentation.signup

import androidx.annotation.StringRes

sealed class SignUpSideEffect {
    data class Toast(val message: String) : SignUpSideEffect()
    data object NavigateUp : SignUpSideEffect()
}
