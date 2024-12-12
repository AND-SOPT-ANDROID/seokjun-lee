package org.sopt.and.presentation.mypage.contract

import org.sopt.and.core.viewmodel.UiState
import org.sopt.and.domain.entity.Program

data class MyPageUiState(
    val hobby: String = "",
    val searchDialogVisibility: Boolean = false,
    val deleteDialogVisibility: Boolean = false,
    val pressedProgram: Program? = null,
): UiState