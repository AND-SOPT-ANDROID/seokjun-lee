package org.sopt.and.presentation.search.state

import org.sopt.and.core.model.Program

data class SearchUiState(
    val popularSeries: List<Program> = emptyList(),
    val popularMovies: List<Program> = emptyList(),
    val selectedTabIndex: Int = 0,
    val searchText: String = ""
)



