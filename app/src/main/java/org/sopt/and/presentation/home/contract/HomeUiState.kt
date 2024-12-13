package org.sopt.and.presentation.home.contract

import org.sopt.and.core.viewmodel.UiState
import org.sopt.and.domain.entity.HomeRecommendation

data class HomeUiState(
    val selectedTabIndex: Int = 0,
    val bannerImgList: List<Int> = emptyList(),
    val recommendations: List<HomeRecommendation> = emptyList(),
    val rankedSeries: HomeRecommendation? = null
) : UiState
