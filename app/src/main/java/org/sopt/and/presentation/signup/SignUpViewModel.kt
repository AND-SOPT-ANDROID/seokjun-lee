package org.sopt.and.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.usecase.SignUpUseCase
import org.sopt.and.presentation.signup.state.SignUpUiState
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val registerUserUseCase: SignUpUseCase
) : ViewModel() {
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

    fun updateHobby(hobby: String) {
        _uiState.update { currentState ->
            currentState.copy(hobby = hobby)
        }
        updateButtonEnabled()
    }

    private fun updateButtonEnabled() = _uiState.update { currentState ->
        currentState.copy(
            isButtonEnabled = _uiState.value.id.isNotBlank()
                    && _uiState.value.password.isNotBlank()
                    && _uiState.value.hobby.isNotBlank()
        )
    }

    fun registerUser() = viewModelScope.launch {
        with(_uiState.value) {
            if (isButtonEnabled) {
                registerUserUseCase.invoke(User(id, password, hobby))
                    .onSuccess { response ->
                        _sideEffect.emit(SignUpSideEffect.Toast(response.message))
                        if (response.id != null) {
                            _sideEffect.emit(SignUpSideEffect.NavigateUp)
                        }
                    }.onFailure { throwable ->
                        _sideEffect.emit(SignUpSideEffect.Toast(throwable.message.orEmpty()))
                    }
            }
        }
    }
}