package org.sopt.and.presentation.search

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.and.core.data.repository.PopularProgramRepository
import org.sopt.and.core.model.Program
import org.sopt.and.presentation.search.state.SearchUiState
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val popularProgramRepository: PopularProgramRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(SearchUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getPopularList()
    }

    private fun getPopularList() = _uiState.update { currentState ->
        currentState.copy(
            popularSeries = popularProgramRepository.getPopularSeries(),
            popularMovies = popularProgramRepository.getPopularMovies()
        )
    }

    fun getTabList(): List<Program> =
        if (uiState.value.selectedTabIndex == 0) _uiState.value.popularSeries
        else _uiState.value.popularMovies

    fun onTabClick(index: Int) = _uiState.update { currentState ->
        currentState.copy(
            selectedTabIndex = index
        )
    }

    fun onSearchValueChange(value: String) = _uiState.update { currentState ->
        currentState.copy(
            searchText = value
        )
    }
}