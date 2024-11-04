package org.sopt.and.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.remote.UserService
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {

    @Provides
    @Singleton
    fun providesUserService(
        retrofit: Retrofit
    ): UserService = retrofit.create(UserService::class.java)

}