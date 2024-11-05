package org.sopt.and.presentation.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.sopt.and.R
import org.sopt.and.data.dto.BaseResponse
import org.sopt.and.data.dto.response.SignInResponseDto
import org.sopt.and.domain.entity.User
import org.sopt.and.domain.repository.SignInRepository
import org.sopt.and.presentation.signin.state.SignInUiState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    fun onSignInButtonClick() {
        val user = with(_uiState.value) { User(id, password, "") }
        signInRepository.signInUser(user)
            .enqueue(object : Callback<BaseResponse<SignInResponseDto>> {
                override fun onResponse(
                    call: Call<BaseResponse<SignInResponseDto>>,
                    response: Response<BaseResponse<SignInResponseDto>>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()
                        body?.result?.token?.let {
                            viewModelScope.launch {
                                _sideEffect.emit(SignInSideEffect.NavigateToHome(it))
                            }
                        }
                    } else {
                        response.errorBody()?.run {
                            val body = JSONObject(string())
                            Log.d("error", body.getString("code"))
                            viewModelScope.launch {
                                _sideEffect.emit(SignInSideEffect.SnackBar(R.string.signin_snackbar_fail))
                            }
                        }

                    }
                }

                override fun onFailure(
                    call: Call<BaseResponse<SignInResponseDto>>,
                    response: Throwable
                ) {
                    Log.d("error", response.toString())
                }

            })
    }


}