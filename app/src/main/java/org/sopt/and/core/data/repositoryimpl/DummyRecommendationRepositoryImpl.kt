package org.sopt.and.core.data.repositoryimpl

import org.sopt.and.R
import org.sopt.and.core.data.repository.RecommendationRepository
import org.sopt.and.core.model.HomeRecommendation
import javax.inject.Inject

class DummyRecommendationRepositoryImpl @Inject constructor(

) : RecommendationRepository {
    private val tempImgList = listOf(
        R.drawable.img_banner1,
        R.drawable.img_banner2,
        R.drawable.img_banner3,
        R.drawable.img_banner4,
    )

    override fun getBannerImages(): List<Int> = tempImgList

    override fun getRecommendations(): List<HomeRecommendation> =
        listOf(
            HomeRecommendation(
                title = "믿고 보는 웨이브 에디터 추천작",
                imageList = tempImgList + tempImgList
            ),
            HomeRecommendation(
                title = "실시간 인기 콘텐츠",
                imageList = tempImgList + tempImgList
            ),
            HomeRecommendation(
                title = "오직 웨이브에서",
                imageList = tempImgList + tempImgList
            )
        )
}

