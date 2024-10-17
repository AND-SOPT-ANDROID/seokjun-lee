package org.sopt.and.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.and.core.data.repository.StarredProgramRepository
import org.sopt.and.core.model.Program
import org.sopt.and.presentation.mypage.state.MyPageInteractionState
import org.sopt.and.presentation.mypage.state.MyPageUiState
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val starredProgramRepository: StarredProgramRepository
) : ViewModel() {
    private var interactionState = MutableStateFlow(MyPageInteractionState())
    private val starredState: StateFlow<List<Program>> =
        starredProgramRepository.getStarredPrograms()
            .map { it.map { entity -> Program(entity.programName, entity.programImage) } }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(1000),
                initialValue = emptyList()
            )

    val uiState: StateFlow<MyPageUiState> = combine(
        interactionState, starredState
    ) { uiState, starredState ->
        MyPageUiState().copy(
            searchDialogVisibility = uiState.searchDialogVisibility,
            deleteDialogVisibility = uiState.deleteDialogVisibility,
            pressedProgram = uiState.pressedProgram,
            starredProgram = starredState
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = MyPageUiState(),
    )

    private var _sideEffect = MutableSharedFlow<MyPageSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onLogoutButtonClick() = viewModelScope.launch {
        _sideEffect.emit(MyPageSideEffect.OnLogout)
    }

    fun onConfirmDelete() = viewModelScope.launch {
        interactionState.value.pressedProgram?.run {
            starredProgramRepository.deletedStarredProgram(this)
        }
        updateDeleteDialogVisibility(false)
    }

    fun updateSearchDialogVisibility(visibility: Boolean) =
        interactionState.update { currentState ->
            currentState.copy(searchDialogVisibility = visibility)
        }

    fun updateDeleteDialogVisibility(visibility: Boolean) =
        interactionState.update { currentState ->
            currentState.copy(
                deleteDialogVisibility = visibility
            )
        }

    fun updatePressedProgram(program: Program) {
        interactionState.update { currentState ->
            currentState.copy(pressedProgram = program)
        }
    }

    fun onInsertProgram(program: Program) = viewModelScope.launch {
        if (uiState.value.starredProgram.contains(program)) return@launch

        starredProgramRepository.postStarredProgram(program)
    }
}