package org.sopt.and.presentation.signup.contract

import org.sopt.and.core.viewmodel.UiState

data class SignUpUiState(
    val id: String = "",
    val password: String = "",
    val hobby: String = "",
    val isButtonEnabled: Boolean = false
): UiState
