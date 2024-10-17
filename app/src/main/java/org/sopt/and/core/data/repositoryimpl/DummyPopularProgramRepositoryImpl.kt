package org.sopt.and.core.data.repositoryimpl

import org.sopt.and.R
import org.sopt.and.core.data.repository.PopularProgramRepository
import org.sopt.and.core.model.Program
import javax.inject.Inject

class DummyPopularProgramRepositoryImpl @Inject constructor() : PopularProgramRepository {
    override fun getPopularSeries(): List<Program> = dummyPopularSeries

    override fun getPopularMovies(): List<Program> = dummyPopularMovies

    companion object {
        val dummyPopularSeries = listOf(
            Program(
                title = "원피스",
                imgFile = R.drawable.img_banner1
            ),
            Program(
                title = "런닝맨",
                imgFile = R.drawable.img_banner2
            ),
            Program(
                title = "지옥에서 온 판사",
                imgFile = R.drawable.img_banner3
            ),
            Program(
                title = "여왕벌 게임",
                imgFile = R.drawable.img_banner4
            )
        )
        val dummyPopularMovies = listOf(
            Program(
                title = "올드보이",
                imgFile = R.drawable.img_banner1
            ),
            Program(
                title = "기생충",
                imgFile = R.drawable.img_banner2
            ),
            Program(
                title = "센과 치히로의 행방불명",
                imgFile = R.drawable.img_banner3
            ),
            Program(
                title = "이웃집 토토로",
                imgFile = R.drawable.img_banner4
            ),
            Program(
                title = "추격자",
                imgFile = R.drawable.img_banner1
            ),
            Program(
                title = "조커",
                imgFile = R.drawable.img_banner2
            ),
            Program(
                title = "악마를 보았다",
                imgFile = R.drawable.img_banner3
            ),
            Program(
                title = "슈퍼배드",
                imgFile = R.drawable.img_banner4
            ),
            Program(
                title = "비긴어게인",
                imgFile = R.drawable.img_banner1
            )
        )
    }
}