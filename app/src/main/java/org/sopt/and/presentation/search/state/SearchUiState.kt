package org.sopt.and.presentation.search.state

data class SearchUiState(
    val popularSeries: List<String> = emptyList(),
    val popularMovies: List<String> = emptyList(),
    val selectedTabIndex: Int = 0,
    val searchText: String = ""
)



