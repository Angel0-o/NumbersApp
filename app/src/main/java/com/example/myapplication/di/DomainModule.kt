package com.example.myapplication.di

import com.example.myapplication.domain.repositories.NumberRepository
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import com.example.myapplication.domain.usecases.number.GetNumberByOrderRepetitionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideAddNumberUseCase(
        repository: NumberRepository,
        background: CoroutineDispatcher
    ) = AddNumberUseCase(repository, background)

    @Provides
    @Singleton
    fun provideGetNumbersByOrderRepetitionUseCase(
        repository: NumberRepository,
        background: CoroutineDispatcher
    ) = GetNumberByOrderRepetitionUseCase(repository, background)

}