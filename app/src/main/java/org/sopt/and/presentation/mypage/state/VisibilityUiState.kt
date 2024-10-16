package org.sopt.and.presentation.mypage.state

import org.sopt.and.core.model.Program

data class VisibilityUiState(
    val searchDialogVisibility: Boolean = false,
    val deleteDialogVisibility: Boolean = false,
    val pressedProgram: Program? = null,
)