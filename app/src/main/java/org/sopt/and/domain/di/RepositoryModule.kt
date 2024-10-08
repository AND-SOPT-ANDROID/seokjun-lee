package org.sopt.and.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.repositoryImpl.SignInRepositoryImpl
import org.sopt.and.domain.repository.SignInRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSignInRepository(
        signInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository

}