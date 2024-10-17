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
import org.sopt.and.R
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

    fun onLoginButtonClick(id: String, password: String) = viewModelScope.launch {
        if (isLoginPossible(id, password)) {
            _sideEffect.emit(SignInSideEffect.NavigateToMyPage)
        } else {
            _sideEffect.emit(SignInSideEffect.SnackBar(R.string.signin_snackbar_fail))
        }
    }

    fun onSignUpButtonClick() = viewModelScope.launch {
        _sideEffect.emit(SignInSideEffect.NavigateToSignUp)
    }

    /*id, password -> 회원가입 화면에서 가져온 아이디 비번*/
    private fun isLoginPossible(id: String, password: String): Boolean {
        val isIdCorrect = _uiState.value.id == id && id.isNotBlank()
        val isPasswordCorrect = _uiState.value.password == password && password.isNotBlank()

        return isIdCorrect && isPasswordCorrect
    }


}