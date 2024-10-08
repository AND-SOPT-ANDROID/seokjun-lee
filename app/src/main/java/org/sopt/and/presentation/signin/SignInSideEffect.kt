package org.sopt.and.presentation.signin

sealed class SignInSideEffect{
    data class Toast(val message: String) : SignInSideEffect()
    data class SnackBar(val message: String) : SignInSideEffect()
    data object NavigateToMyPage : SignInSideEffect()
    data object NavigateToSignUp : SignInSideEffect()
}
