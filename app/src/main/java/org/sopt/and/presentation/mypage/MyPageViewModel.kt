package org.sopt.and.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.core.data.repository.StarredProgramRepository
import org.sopt.and.core.model.Program
import org.sopt.and.presentation.mypage.state.MyPageUiState
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val starredProgramRepository: StarredProgramRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(MyPageUiState())
    val uiState = _uiState.asStateFlow()

    private var _sideEffect = MutableSharedFlow<MyPageSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onLogoutButtonClick() = viewModelScope.launch {
        _sideEffect.emit(MyPageSideEffect.OnLogout)
    }

    fun updateSearchDialogVisibility(visibility: Boolean) = _uiState.update { currentState ->
        currentState.copy(searchDialogVisibility = visibility)
    }

    fun updateDeleteDialogVisibility(visibility: Boolean) = _uiState.update { currentState ->
        currentState.copy(deleteDialogVisibility = visibility)
    }
}