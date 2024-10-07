package org.sopt.and.presentation.signup

sealed class SignUpSideEffect{
    data class Toast(val message: String) : SignUpSideEffect()
    data object NavigateUp : SignUpSideEffect()
}
