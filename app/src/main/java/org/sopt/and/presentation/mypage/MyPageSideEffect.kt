package org.sopt.and.presentation.mypage

sealed class MyPageSideEffect {
    data object OnLogout : MyPageSideEffect()
}