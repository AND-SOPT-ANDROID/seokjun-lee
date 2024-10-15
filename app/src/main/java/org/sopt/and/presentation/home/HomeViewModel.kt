package org.sopt.and.presentation.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.and.core.domain.entity.HomeRecommendation
import org.sopt.and.presentation.home.state.HomeUiState

class HomeViewModel : ViewModel() {
    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun updateSelectedTabIndex(index: Int) = _uiState.update { currentState ->
        currentState.copy(selectedTabIndex = index)
    }

    fun getRecommendations() = _uiState.update { currentState ->
        currentState.copy(
            recommendations = listOf(
                HomeRecommendation(
                    title = "믿고 보는 웨이브 에디터 추천작",
                    imageList = _uiState.value.bannerImgList + _uiState.value.bannerImgList
                ),
                HomeRecommendation(
                    title = "실시간 인기 콘텐츠",
                    imageList = _uiState.value.bannerImgList + _uiState.value.bannerImgList
                ),
                HomeRecommendation(
                    title = "오직 웨이브에서",
                    imageList = _uiState.value.bannerImgList + _uiState.value.bannerImgList
                )
            )
        )
    }
}