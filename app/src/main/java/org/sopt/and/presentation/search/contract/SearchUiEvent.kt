package org.sopt.and.presentation.search.contract

import org.sopt.and.core.viewmodel.UiEvent

sealed class SearchUiEvent: UiEvent {
    data class OnTabClicked(val index: Int): SearchUiEvent()
    data class OnSearchTextFieldChanged(val value: String): SearchUiEvent()
}