package org.sopt.and.presentation.signin.contract

import org.sopt.and.core.viewmodel.UiState


data class SignInUiState(
    val id: String = "",
    val password: String = ""
): UiState