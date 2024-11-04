package org.sopt.and.data.repositoryimpl

import org.sopt.and.R
import org.sopt.and.core.model.HomeRecommendation
import org.sopt.and.core.model.Program
import org.sopt.and.data.repository.RecommendationRepository
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
                programList = DummyPopularProgramRepositoryImpl.dummyPopularSeries
            ),
            HomeRecommendation(
                title = "실시간 인기 콘텐츠",
                programList = DummyPopularProgramRepositoryImpl.dummyPopularMovies
            ),
            HomeRecommendation(
                title = "오직 웨이브에서",
                programList = DummyPopularProgramRepositoryImpl.dummyPopularSeries
            )
        )

    override fun getMostPopularSeries(): HomeRecommendation = HomeRecommendation(
        title = "",
        programList = listOf(
            Program(
                title = "나는 솔로",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202309/1694062313324743958.webp"
            ),
            Program(
                title = "꼬리에 꼬리를 무는 그날이야기",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202307/1688707846915136240.webp"
            ),
            Program(
                title = "지옥에서 온 판사",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202409/1726468463104944317.webp"
            ),
            Program(
                title = "런닝맨",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202311/1698908212143109040.webp"
            ),
            Program(
                title = "나 혼자 산다",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202311/1699601586197251349.webp"
            ),
            Program(
                title = "골 때리는 그녀들",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202307/1690523370531767356.webp"
            ),
            Program(
                title = "틈만 나면",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202410/1728613201561457273.webp"
            ),
            Program(
                title = "용감무쌍 용수정",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202405/1715069627941981919.webp"
            ),
            Program(
                title = "라디오스타",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202311/1700742608486397915.webp"
            ),
            Program(
                title = "나는 SOLO, 그 후 사랑은 계속된",
                imgUrl = "https://image.wavve.com/v1/thumbnails/480_720_20_80/meta/image/202407/1720056473854435313.webp"
            ),
        )
    )
}

