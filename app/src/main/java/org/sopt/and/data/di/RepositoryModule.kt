package org.sopt.and.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.repositoryimpl.DummyPopularProgramRepositoryImpl
import org.sopt.and.data.repositoryimpl.DummyRecommendationRepositoryImpl
import org.sopt.and.data.repositoryimpl.MyHobbyRepositoryImpl
import org.sopt.and.data.repositoryimpl.SignInRepositoryImpl
import org.sopt.and.data.repositoryimpl.SignUpRepositoryImpl
import org.sopt.and.data.repositoryimpl.StarredProgramRepositoryImpl
import org.sopt.and.domain.repository.MyHobbyRepository
import org.sopt.and.domain.repository.PopularProgramRepository
import org.sopt.and.domain.repository.RecommendationRepository
import org.sopt.and.domain.repository.SignInRepository
import org.sopt.and.domain.repository.SignUpRepository
import org.sopt.and.domain.repository.StarredProgramRepository
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

    @Binds
    @Singleton
    abstract fun bindsSignUpRepository(
        signUpRepositoryImpl: SignUpRepositoryImpl
    ): SignUpRepository


    @Binds
    @Singleton
    abstract fun bindsSignInRepository(
        signInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository

    @Binds
    @Singleton
    abstract fun bindsMyHobbyRepository(
        myHobbyRepositoryImpl: MyHobbyRepositoryImpl
    ): MyHobbyRepository

}
