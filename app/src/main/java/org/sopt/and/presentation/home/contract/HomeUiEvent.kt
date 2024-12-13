package org.sopt.and.presentation.home.contract

import org.sopt.and.core.viewmodel.UiEvent

sealed class HomeUiEvent: UiEvent {
    data class OnTabSelected(val index: Int): HomeUiEvent()
}
