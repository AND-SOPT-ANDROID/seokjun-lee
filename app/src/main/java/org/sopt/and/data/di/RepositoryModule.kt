package org.sopt.and.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.repository.PopularProgramRepository
import org.sopt.and.data.repository.RecommendationRepository
import org.sopt.and.data.repository.StarredProgramRepository
import org.sopt.and.data.repositoryimpl.DummyPopularProgramRepositoryImpl
import org.sopt.and.data.repositoryimpl.DummyRecommendationRepositoryImpl
import org.sopt.and.data.repositoryimpl.StarredProgramRepositoryImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule() {

    @Binds
    @Singleton
    abstract fun bindsDummyRecommendationRepository(
        recommendationRepositoryImpl: DummyRecommendationRepositoryImpl
    ): RecommendationRepository

    @Binds
    @Singleton
    abstract fun bindsDummyPopularProgramRepository(
        popularProgramRepositoryImpl: DummyPopularProgramRepositoryImpl
    ): PopularProgramRepository

    @Binds
    @Singleton
    abstract fun bindsStarredProgramRepository(
        starredProgramRepositoryImpl: StarredProgramRepositoryImpl
    ): StarredProgramRepository
}
