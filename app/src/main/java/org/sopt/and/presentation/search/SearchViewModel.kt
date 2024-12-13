package org.sopt.and.presentation.search

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.core.viewmodel.BaseViewModel
import org.sopt.and.domain.entity.Program
import org.sopt.and.domain.repository.PopularProgramRepository
import org.sopt.and.presentation.search.contract.SearchSideEffect
import org.sopt.and.presentation.search.contract.SearchUiEvent
import org.sopt.and.presentation.search.contract.SearchUiState
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val popularProgramRepository: PopularProgramRepository
) : BaseViewModel<SearchUiState, SearchSideEffect, SearchUiEvent>() {
    override fun createInitialState(): SearchUiState = SearchUiState()

    override suspend fun handleEvent(event: SearchUiEvent) {
        when (event) {
            is SearchUiEvent.OnTabClicked -> {
                setState { copy(selectedTabIndex = event.index) }
            }

            is SearchUiEvent.OnSearchTextFieldChanged -> {
                setState { copy(searchText = event.value) }
            }
        }
    }

    fun getPopularList() {
        setState {
            copy(
                popularSeries = popularProgramRepository.getPopularSeries(),
                popularMovies = popularProgramRepository.getPopularMovies()
            )
        }
    }

    fun getTabList(): List<Program> {
        val (tabList, toastMessage) =
            if (uiState.value.selectedTabIndex == 0) {
                Pair(currentState.popularSeries, "인기시리즈")
            } else {
                Pair(currentState.popularMovies, "인기 영화")
            }

        setSideEffect(SearchSideEffect.ShowToast(toastMessage))
        return tabList
    }
}