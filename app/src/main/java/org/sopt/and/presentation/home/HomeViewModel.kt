package org.sopt.and.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.and.core.data.repository.RecommendationRepository
import org.sopt.and.presentation.home.state.HomeUiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val recommendationRepository: RecommendationRepository
) : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeHomeState()
    }

    private fun initializeHomeState() = _uiState.update { currentState ->
        currentState.copy(
            bannerImgList = recommendationRepository.getBannerImages(),
            recommendations = recommendationRepository.getRecommendations()
        )
    }

    fun updateSelectedTabIndex(index: Int) = _uiState.update { currentState ->
        currentState.copy(selectedTabIndex = index)
    }
}