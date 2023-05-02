package com.example.myapplication.di

import com.example.myapplication.data.local.source.NumberLocalDataSourceImpl
import com.example.myapplication.data.repositories.NumberLocalDataSource
import com.example.myapplication.data.repositories.NumberRepositoryImpl
import com.example.myapplication.domain.repositories.NumberRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindNumberRepository(
        repositoryImpl: NumberRepositoryImpl
    ): NumberRepository

    @Binds
    fun bindNumberLocalDataSource(
        localDataSourceImpl: NumberLocalDataSourceImpl
    ): NumberLocalDataSource
}