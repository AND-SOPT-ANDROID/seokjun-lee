package org.sopt.and.domain.repository

import org.sopt.and.domain.entity.HomeRecommendation

interface RecommendationRepository {
    fun getBannerImages(): List<Int>
    fun getRecommendations(): List<HomeRecommendation>
    fun getMostPopularSeries(): HomeRecommendation
}