package org.sopt.and.presentation.home.state

import org.sopt.and.R
import org.sopt.and.core.domain.entity.HomeRecommendation

data class HomeUiState(
    val selectedTabIndex: Int = 0,
    val bannerImgList: List<Int> = tempImgList,
    val recommendations: List<HomeRecommendation> = emptyList()
)

private val tempImgList = listOf(
    R.drawable.img_banner1,
    R.drawable.img_banner2,
    R.drawable.img_banner3,
    R.drawable.img_banner4,
)