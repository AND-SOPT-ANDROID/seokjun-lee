package org.sopt.and.presentation.signin.contract

import org.sopt.and.core.viewmodel.UiSideEffect

sealed interface SignInSideEffect: UiSideEffect {
    data class ShowToast(val message: String) : SignInSideEffect
    data class ShowSnackBar(val message: String) : SignInSideEffect
    data class NavigateToHome(val token: String) : SignInSideEffect
    data object NavigateToSignUp : SignInSideEffect
}
