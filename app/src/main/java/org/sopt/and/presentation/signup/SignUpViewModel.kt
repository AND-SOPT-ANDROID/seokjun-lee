package org.sopt.and.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.R
import org.sopt.and.presentation.signup.state.SignUpUiState

class SignUpViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignUpSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun updateId(id: String) {
        _uiState.update { currentState ->
            currentState.copy(id = id)
        }
        updateButtonEnabled()
    }

    fun updatePassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(password = password)
        }
        updateButtonEnabled()
    }

    private fun updateButtonEnabled() = _uiState.update { currentState ->
        currentState.copy(
            isButtonEnabled = _uiState.value.id.isNotBlank() && _uiState.value.password.isNotBlank()
        )
    }

    fun checkTextFields() = viewModelScope.launch {
        val isValidEmail = isValidEmail(_uiState.value.id)
        val isValidPassword = isValidPassword(_uiState.value.password)

        when {
            isValidEmail && isValidPassword -> {
                with(_sideEffect) {
                    emit(SignUpSideEffect.Toast(R.string.signup_toast_success))
                    emit(SignUpSideEffect.NavigateUp)
                }
            }
            !isValidEmail -> _sideEffect.emit(SignUpSideEffect.Toast(R.string.signup_toast_failure_email))
            else -> _sideEffect.emit(SignUpSideEffect.Toast(R.string.signup_toast_failure_password))
        }
    }

    private fun isValidEmail(email: String): Boolean = email.matches(EMAIL_REGEX.toRegex())


    private fun isValidPassword(password: String): Boolean {
        var count = 0

        if (password.contains(UPPER_CASE_REGEX.toRegex())) count++
        if (password.contains(LOWER_CASE_REGEX.toRegex())) count++
        if (password.contains(DIGIT_REGEX.toRegex())) count++
        if (password.contains(SPECIAL_CHAR_REGEX.toRegex())) count++

        return password.length in PWD_LENGTH_MIN..PWD_LENGTH_MAX && count >= PWD_TYPE_MIX
    }

    companion object {
        private const val PWD_LENGTH_MIN = 8
        private const val PWD_LENGTH_MAX = 20
        private const val PWD_TYPE_MIX = 3

        const val EMAIL_REGEX ="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        const val UPPER_CASE_REGEX = "[A-Z]"
        const val LOWER_CASE_REGEX = "[a-z]"
        const val DIGIT_REGEX = "[0-9]"
        const val SPECIAL_CHAR_REGEX = "[!@#\$%^&*(),.?\":{}|<>]"

    }
}