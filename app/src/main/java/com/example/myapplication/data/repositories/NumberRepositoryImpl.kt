package com.example.myapplication.data.repositories

import com.example.myapplication.data.mappers.toListEntity
import com.example.myapplication.data.models.NumberModel
import com.example.myapplication.domain.entities.NumberEntity
import com.example.myapplication.domain.repositories.NumberRepository
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class NumberRepositoryImpl @Inject constructor(
    private val localDataSource: NumberLocalDataSource
) : NumberRepository {

    override fun getNumbersOrderByRepetitions(): Flow<List<NumberEntity>> =
        localDataSource.getNumbersOrderByRepetitions().map { it.toListEntity() }

    override suspend fun addNumber(params: AddNumberUseCase.Params) {
        localDataSource.addNumber(params)
    }

}


internal interface NumberLocalDataSource {
    suspend fun addNumber(params: AddNumberUseCase.Params)
    fun getNumbersOrderByRepetitions(): Flow<List<NumberModel>>
}