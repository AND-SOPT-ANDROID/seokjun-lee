package org.sopt.and.presentation.mypage

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.sopt.and.core.viewmodel.BaseViewModel
import org.sopt.and.domain.entity.Program
import org.sopt.and.domain.repository.MyHobbyRepository
import org.sopt.and.domain.repository.StarredProgramRepository
import org.sopt.and.presentation.mypage.contract.MyPageSideEffect
import org.sopt.and.presentation.mypage.contract.MyPageUiEvent
import org.sopt.and.presentation.mypage.contract.MyPageUiState
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val starredProgramRepository: StarredProgramRepository,
    private val myHobbyRepository: MyHobbyRepository
) : BaseViewModel<MyPageUiState, MyPageSideEffect, MyPageUiEvent>() {

    val starredState: StateFlow<List<Program>> =
        starredProgramRepository.getStarredPrograms()
            .map { it.map { entity -> Program(title = entity.programName, imgFile = entity.programImage) } }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(1000),
                initialValue = emptyList()
            )
    private val currentStarredState: List<Program>
        get() = starredState.value

    override fun createInitialState(): MyPageUiState = MyPageUiState()

    override suspend fun handleEvent(event: MyPageUiEvent) {
        when (event) {
            is MyPageUiEvent.OnLogoutButtonClick -> {
                setSideEffect(MyPageSideEffect.OnLogout)
            }

            is MyPageUiEvent.OnFAButtonClick -> {
                setState { copy(searchDialogVisibility = true) }
            }

            is MyPageUiEvent.OnSearchDialogDismissed -> {
                setState { copy(searchDialogVisibility = false) }
            }

            is MyPageUiEvent.OnSearchProgramSelected -> {
                insertProgramToLocal(program = event.program)
            }

            is MyPageUiEvent.OnStarredProgramPressed -> {
                setState {
                    copy(
                        pressedProgram = event.program,
                        deleteDialogVisibility = true
                    )
                }
            }

            is MyPageUiEvent.OnDeleteDialogDismissed -> {
                setState { copy(deleteDialogVisibility = false) }
            }

            is MyPageUiEvent.OnDeleteProgramConfirmed -> {
                deleteProgramFromLocal()
                setState { copy(deleteDialogVisibility = false) }
            }

        }
    }

    suspend fun getMyHobby(token: String) {
        myHobbyRepository.getMyHobby(token)
            .onSuccess { hobby ->
                setState { copy(hobby = hobby.hobby) }
            }
    }

    private suspend fun deleteProgramFromLocal() {
        currentState.pressedProgram?.run {
            starredProgramRepository.deletedStarredProgram(this)
        }
    }

    private suspend fun insertProgramToLocal(program: Program) {
        if (currentStarredState.contains(program))
            return

        starredProgramRepository.postStarredProgram(program)
    }
}