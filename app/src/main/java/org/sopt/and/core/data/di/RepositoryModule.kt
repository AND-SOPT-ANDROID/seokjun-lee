package org.sopt.and.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.core.data.repository.RecommendationRepository
import org.sopt.and.core.data.repositoryimpl.DummyRecommendationRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule() {

    @Binds
    @Singleton
    abstract fun bindsDummyRecommendationRepository(
        recommendationRepositoryImpl: DummyRecommendationRepositoryImpl
    ): RecommendationRepository
}
