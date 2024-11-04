package org.sopt.and.domain.repository

import org.sopt.and.core.model.HomeRecommendation

interface RecommendationRepository {
    fun getBannerImages(): List<Int>
    fun getRecommendations(): List<HomeRecommendation>
    fun getMostPopularSeries(): HomeRecommendation
}