package org.sopt.and.presentation.home.state

import org.sopt.and.core.model.HomeRecommendation

data class HomeUiState(
    val selectedTabIndex: Int = 0,
    val bannerImgList: List<Int> = emptyList(),
    val recommendations: List<HomeRecommendation> = emptyList()
)
