package org.sopt.and.presentation.signin.contract

import org.sopt.and.core.viewmodel.UiEvent

sealed class SignInUiEvent: UiEvent {
    data class OnIdTextFieldChanged(val id: String): SignInUiEvent()
    data class OnPasswordTextFieldChanged(val password: String): SignInUiEvent()
    data object OnSignInButtonClicked: SignInUiEvent()
    data object OnSignUpButtonClicked: SignInUiEvent()
}