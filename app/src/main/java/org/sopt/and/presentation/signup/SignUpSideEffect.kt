package org.sopt.and.presentation.signup

import androidx.annotation.StringRes

sealed class SignUpSideEffect{
    data class Toast(@StringRes val message: Int) : SignUpSideEffect()
    data object NavigateUp : SignUpSideEffect()
}
