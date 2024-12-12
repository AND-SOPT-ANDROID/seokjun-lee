package org.sopt.and.presentation.signin.contract

import org.sopt.and.core.viewmodel.UiEvent

sealed class SignInEvent: UiEvent {
    data class OnIdTextFieldChanged(val id: String): SignInEvent()
    data class OnPasswordTextFieldChanged(val password: String): SignInEvent()
    data object OnSignInButtonClicked: SignInEvent()
    data object OnSignUpButtonClicked: SignInEvent()
}