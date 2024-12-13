package org.sopt.and.presentation.home

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.and.core.viewmodel.BaseViewModel
import org.sopt.and.domain.repository.RecommendationRepository
import org.sopt.and.presentation.home.contract.HomeUiEvent
import org.sopt.and.presentation.home.contract.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recommendationRepository: RecommendationRepository
) : BaseViewModel<HomeUiState, Nothing, HomeUiEvent>() {
    override fun createInitialState(): HomeUiState = HomeUiState()

    override suspend fun handleEvent(event: HomeUiEvent) {
        when(event) {
            is HomeUiEvent.OnTabSelected -> {
                setState { copy(selectedTabIndex = event.index) }
            }
        }
    }

    fun initializeHomeState() {
        setState {
            copy(
                bannerImgList = recommendationRepository.getBannerImages(),
                recommendations = recommendationRepository.getRecommendations(),
                rankedSeries = recommendationRepository.getMostPopularSeries()
            )
        }
    }
}