package org.sopt.and.presentation.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.presentation.signin.state.SignInUiState
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {
    private var _uiState = MutableStateFlow(SignInUiState())
    val uiState = _uiState.asStateFlow()

    private var _sideEffect = MutableSharedFlow<SignInSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun updateId(id: String) = _uiState.update { currentState ->
        currentState.copy(
            id = id
        )
    }

    fun updatePassword(password: String) = _uiState.update { currentState ->
        currentState.copy(
            password = password
        )
    }

    fun onLoginButtonClick() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.SnackBar("로그인 버튼 선택"))
        _sideEffect.emit(SignInSideEffect.NavigateToMyPage)
    }

    fun onSignUpButtonClick() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateToSignUp)
    }


}