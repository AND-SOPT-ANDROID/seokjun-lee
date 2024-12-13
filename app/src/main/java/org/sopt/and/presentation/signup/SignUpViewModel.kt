package org.sopt.and.presentation.signup

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.and.core.viewmodel.BaseViewModel
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.usecase.SignUpUseCase
import org.sopt.and.presentation.signup.contract.SignUpSideEffect
import org.sopt.and.presentation.signup.contract.SignUpUiEvent
import org.sopt.and.presentation.signup.contract.SignUpUiState
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val registerUserUseCase: SignUpUseCase
) : BaseViewModel<SignUpUiState, SignUpSideEffect, SignUpUiEvent>() {

    override fun createInitialState(): SignUpUiState = SignUpUiState()

    override suspend fun handleEvent(event: SignUpUiEvent) {
        when(event) {
            is SignUpUiEvent.OnIdTextFieldChanged -> {
                val isButtonEnabled = checkSignUpPossible()
                setState { copy(id = event.id, isButtonEnabled = isButtonEnabled) }
            }
            is SignUpUiEvent.OnPasswordTextFieldChanged -> {
                val isButtonEnabled = checkSignUpPossible()
                setState { copy(password = event.password, isButtonEnabled = isButtonEnabled) }
            }
            is SignUpUiEvent.OnHobbyTextFieldChanged -> {
                val isButtonEnabled = checkSignUpPossible()
                setState { copy(hobby = event.hobby, isButtonEnabled = isButtonEnabled) }
            }
            is SignUpUiEvent.OnCloseButtonClicked -> {
                setSideEffect(sideEffect = SignUpSideEffect.NavigateUp)
            }
            is SignUpUiEvent.OnSignUpButtonClicked -> {
                registerUser()
            }
        }
    }

    private fun checkSignUpPossible():Boolean = with(currentState) {
        id.isNotBlank() && password.isNotBlank() && hobby.isNotBlank()
    }

    private fun registerUser() = viewModelScope.launch {
        with(currentState) {
            if (isButtonEnabled) {
                registerUserUseCase.invoke(User(id, password, hobby))
                    .onSuccess { response ->
                        setSideEffect(SignUpSideEffect.ShowToast(response.message))
                        if (response.id != null) {
                            setSideEffect(SignUpSideEffect.NavigateUp)
                        }
                    }.onFailure { throwable ->
                        setSideEffect(SignUpSideEffect.ShowToast(throwable.message.orEmpty()))
                    }
            }
        }
    }
}