package org.sopt.and.presentation.signup.contract

import org.sopt.and.core.viewmodel.UiSideEffect

sealed class SignUpSideEffect: UiSideEffect {
    data class ShowToast(val message: String) : SignUpSideEffect()
    data object NavigateUp : SignUpSideEffect()
}
