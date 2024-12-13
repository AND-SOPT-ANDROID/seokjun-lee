package org.sopt.and.presentation.search.contract

import org.sopt.and.core.viewmodel.UiSideEffect

sealed interface SearchSideEffect: UiSideEffect {
    data class ShowToast(val message: String) : SearchSideEffect
}