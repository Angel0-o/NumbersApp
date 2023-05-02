package com.example.myapplication.domain.usecases.number

import com.example.myapplication.domain.entities.NumberEntity
import com.example.myapplication.domain.repositories.NumberRepository
import com.example.myapplication.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNumberByOrderRepetitionUseCase @Inject constructor(
    private val repository: NumberRepository,
    background: CoroutineDispatcher
) : UseCase<Flow<List<NumberEntity>>, Unit>(background) {
    override suspend fun run(input: Unit?): Flow<List<NumberEntity>> {
        return repository.getNumbersOrderByRepetitions()
    }
}