package org.sopt.and.presentation.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.and.domain.repository.SignInRepository
import org.sopt.and.presentation.signin.state.SignInUiState
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInRepository: SignInRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(SignInUiState())
    val uiState = _uiState.asStateFlow()

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

    fun isLoginPossible(id: String, password: String): Boolean {
        val isIdCorrect = _uiState.value.id == id
        val isPasswordCorrect = _uiState.value.password == password

        return isIdCorrect && isPasswordCorrect
    }

    fun isAutoLogin(): Boolean {
        val isIdExist = signInRepository.getIdFromPref().isNotBlank()
        val isPasswordExist = signInRepository.getPasswordFromPref().isNotBlank()

        return isIdExist && isPasswordExist
    }
}