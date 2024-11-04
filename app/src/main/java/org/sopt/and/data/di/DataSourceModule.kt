package org.sopt.and.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.datasource.AuthDataSource
import org.sopt.and.data.datasourceImpl.AuthDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsUserDataSource(
        userDataSourceImpl: AuthDataSourceImpl
    ): AuthDataSource

}