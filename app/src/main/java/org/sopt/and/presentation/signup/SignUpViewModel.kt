package org.sopt.and.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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

        if(isValidEmail && isValidPassword)
            _sideEffect.emit(SignUpSideEffect.Toast("회원가입 성공"))
        else if(!isValidEmail)
            _sideEffect.emit(SignUpSideEffect.Toast("이메일 형식이 올바르지 않습니다."))
        else
            _sideEffect.emit(SignUpSideEffect.Toast("비밀번호 형식이 올바르지 않습니다."))

    }

    private fun isValidEmail(email: String): Boolean {
        val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex()
        return email.matches(regex)
    }

    private fun isValidPassword(password: String): Boolean {
        val upperCaseRegex = Regex("[A-Z]")         // 대문자
        val lowerCaseRegex = Regex("[a-z]")         // 소문자
        val digitRegex = Regex("[0-9]")             // 숫자
        val specialCharRegex = Regex("[!@#\$%^&*(),.?\":{}|<>]") // 특수문자

        var count = 0

        if (password.contains(upperCaseRegex)) count++
        if (password.contains(lowerCaseRegex)) count++
        if (password.contains(digitRegex)) count++
        if (password.contains(specialCharRegex)) count++

        return password.length in 8..20 && count >= 3
    }


}