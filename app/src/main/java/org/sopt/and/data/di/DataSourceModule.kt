package org.sopt.and.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.and.data.datasource.UserDataSource
import org.sopt.and.data.datasourceImpl.UserDataSourceImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindsUserDataSource(
        userDataSourceImpl: UserDataSourceImpl
    ): UserDataSource

}