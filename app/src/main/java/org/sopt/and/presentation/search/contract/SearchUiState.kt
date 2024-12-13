package org.sopt.and.presentation.search.contract

import org.sopt.and.core.viewmodel.UiState
import org.sopt.and.domain.entity.Program

data class SearchUiState(
    val popularSeries: List<Program> = emptyList(),
    val popularMovies: List<Program> = emptyList(),
    val selectedTabIndex: Int = 0,
    val searchText: String = ""
): UiState



