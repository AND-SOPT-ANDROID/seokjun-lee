package org.sopt.and.presentation.signin

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.and.core.viewmodel.BaseViewModel
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.usecase.SignInUseCase
import org.sopt.and.presentation.signin.contract.SignInUiEvent
import org.sopt.and.presentation.signin.contract.SignInSideEffect
import org.sopt.and.presentation.signin.contract.SignInUiState
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : BaseViewModel<SignInUiState, SignInSideEffect, SignInUiEvent>() {

    override fun createInitialState(): SignInUiState = SignInUiState()

    override suspend fun handleEvent(event: SignInUiEvent) {
        when (event) {
            is SignInUiEvent.OnIdTextFieldChanged -> {
                setState { copy(id = event.id) }
            }

            is SignInUiEvent.OnPasswordTextFieldChanged -> {
                setState { copy(password = event.password) }
            }

            SignInUiEvent.OnSignInButtonClicked -> {
                postSignIn()
            }

            SignInUiEvent.OnSignUpButtonClicked -> {
                navigateToSignUp()
            }
        }
    }

    private fun navigateToSignUp() {
        viewModelScope.launch {
            setSideEffect(SignInSideEffect.NavigateToSignUp)
        }
    }

    private fun postSignIn() = viewModelScope.launch {
        val user = with(currentState) { User(id, password, "") }
        signInUseCase.invoke(user).onSuccess { response ->
            response.token?.run {
                setSideEffect(SignInSideEffect.NavigateToHome(this))
            }
        }.onFailure { throwable ->
            setSideEffect(SignInSideEffect.ShowSnackBar(throwable.message.orEmpty()))
        }
    }
}