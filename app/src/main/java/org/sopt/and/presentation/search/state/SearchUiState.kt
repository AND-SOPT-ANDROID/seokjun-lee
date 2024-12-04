package org.sopt.and.presentation.search.state

import org.sopt.and.domain.entity.Program

data class SearchUiState(
    val popularSeries: List<Program> = emptyList(),
    val popularMovies: List<Program> = emptyList(),
    val selectedTabIndex: Int = 0,
    val searchText: String = ""
)



