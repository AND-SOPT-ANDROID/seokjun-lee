package org.sopt.and.presentation.mypage.contract

import org.sopt.and.core.viewmodel.UiEvent
import org.sopt.and.domain.entity.Program

sealed class MyPageUiEvent: UiEvent {
    data object OnLogoutButtonClick: MyPageUiEvent()
    data object OnFAButtonClick: MyPageUiEvent()
    data class OnStarredProgramPressed(val program: Program): MyPageUiEvent()
    data object OnSearchDialogDismissed: MyPageUiEvent()
    data class OnSearchProgramSelected(val program: Program): MyPageUiEvent()
    data object OnDeleteDialogDismissed: MyPageUiEvent()
    data object OnDeleteProgramConfirmed: MyPageUiEvent()
}