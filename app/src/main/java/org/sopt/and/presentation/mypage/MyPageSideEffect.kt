package org.sopt.and.presentation.mypage

import androidx.annotation.StringRes

sealed class MyPageSideEffect {
    data class ShowSnackBar(@StringRes val message: Int) : MyPageSideEffect()
}