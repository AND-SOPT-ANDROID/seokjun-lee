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
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import org.sopt.and.presentation.signin.state.SignInUiState
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInRepository: SignInRepository
) : ViewModel() {
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

    fun onSignUpButtonClick() {
        viewModelScope.launch {
            _sideEffect.emit(SignInSideEffect.NavigateToSignUp)
        }
    }

    fun onSignInButtonClick() = viewModelScope.launch {
        val user = with(_uiState.value) { User(id, password, "") }
        signInRepository.signInUser(user).onSuccess { response ->
            val token = response.token
            if(token != null) {
                    _sideEffect.emit(SignInSideEffect.NavigateToHome(token))
            } else {
                _sideEffect.emit(SignInSideEffect.SnackBar(R.string.signin_snackbar_fail))
            }
        }.onFailure {
            _sideEffect.emit(SignInSideEffect.SnackBar(R.string.signin_snackbar_fail))
        }
    }
}