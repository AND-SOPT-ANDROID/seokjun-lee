package org.sopt.and.presentation.signin

import androidx.annotation.StringRes

sealed class SignInSideEffect{
    data class Toast(@StringRes val message: Int) : SignInSideEffect()
    data class SnackBar(val message: String) : SignInSideEffect()
    data object NavigateToMyPage : SignInSideEffect()
    data object NavigateToSignUp : SignInSideEffect()
}
