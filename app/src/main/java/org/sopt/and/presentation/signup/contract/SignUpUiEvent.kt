package org.sopt.and.presentation.signup.contract

import org.sopt.and.core.viewmodel.UiEvent

sealed class SignUpUiEvent: UiEvent {
    data class OnIdTextFieldChanged(val id: String): SignUpUiEvent()
    data class OnPasswordTextFieldChanged(val password: String): SignUpUiEvent()
    data class OnHobbyTextFieldChanged(val hobby: String): SignUpUiEvent()
    data object OnCloseButtonClicked: SignUpUiEvent()
    data object OnSignUpButtonClicked: SignUpUiEvent()
}