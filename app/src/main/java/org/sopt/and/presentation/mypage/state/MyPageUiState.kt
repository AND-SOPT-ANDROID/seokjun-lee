package org.sopt.and.presentation.mypage.state

import org.sopt.and.core.model.Program
import org.sopt.and.domain.entity.Hobby

data class MyPageUiState(
    val hobby: String = "",
    val searchDialogVisibility: Boolean = false,
    val deleteDialogVisibility: Boolean = false,
    val pressedProgram: Program? = null,
    val starredProgram: List<Program> = emptyList()

)