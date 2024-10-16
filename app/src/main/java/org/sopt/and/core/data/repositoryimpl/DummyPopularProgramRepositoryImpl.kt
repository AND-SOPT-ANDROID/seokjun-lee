package org.sopt.and.core.data.repositoryimpl

import org.sopt.and.core.data.repository.PopularProgramRepository
import javax.inject.Inject

class DummyPopularProgramRepositoryImpl @Inject constructor()
    :PopularProgramRepository{
    override fun getPopularSeries(): List<String> = dummyPopularSeries

    override fun getPopularMovies(): List<String>  = dummyPopularMovies

    private val dummyPopularSeries = listOf(
        "궁금한 이야기 Y",
        "나는 SOLO",
        "무한도전",
        "1박2일",
        "지구오락실",
        "용감무쌍 용수정",
        "여왕벌 게임",
        "돌싱글스",
        "꼬리에 꼬리를 무는 그날 이야기"
    )
    private val dummyPopularMovies = listOf(
        "국가대표",
        "올드보이",
        "기생충",
        "명탐정 코난",
        "택시운전사",
        "추격자",
        "조커",
        "시간을 달리는 소녀",
        "센과 치히로의 행방불명",
        "스파이더맨: 노 웨이 홈"
    )
}