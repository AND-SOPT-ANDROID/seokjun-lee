package org.sopt.and.presentation.mypage

import androidx.annotation.StringRes

sealed class MyPageSideEffect {
    data object OnLogout : MyPageSideEffect()
}