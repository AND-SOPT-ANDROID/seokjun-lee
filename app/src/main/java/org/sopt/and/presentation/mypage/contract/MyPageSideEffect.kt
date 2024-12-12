package org.sopt.and.presentation.mypage.contract

import org.sopt.and.core.viewmodel.UiSideEffect

sealed class MyPageSideEffect: UiSideEffect {
    data object OnLogout : MyPageSideEffect()
}