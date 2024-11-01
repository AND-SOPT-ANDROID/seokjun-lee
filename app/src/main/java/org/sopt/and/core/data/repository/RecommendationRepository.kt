package org.sopt.and.core.data.repository

import org.sopt.and.core.model.HomeRecommendation

interface RecommendationRepository {
    fun getBannerImages(): List<Int>
    fun getRecommendations(): List<HomeRecommendation>
}