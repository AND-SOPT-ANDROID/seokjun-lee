package org.sopt.and.presentation.mypage.state

import org.sopt.and.core.model.Program

data class MyPageUiState(
    val searchDialogVisibility: Boolean = false,
    val deleteDialogVisibility: Boolean = false,
    val starredProgram: List<Program> = emptyList()
)