package org.sopt.and.presentation.signup.state

data class SignUpUiState(
    val id: String = "",
    val password: String = "",
    val hobby: String = "",
    val isButtonEnabled: Boolean = false
)
