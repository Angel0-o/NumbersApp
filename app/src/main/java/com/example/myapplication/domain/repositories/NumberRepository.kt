package com.example.myapplication.domain.repositories

import com.example.myapplication.domain.entities.NumberEntity
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import kotlinx.coroutines.flow.Flow

interface NumberRepository {
    fun getNumbersOrderByRepetitions(): Flow<List<NumberEntity>>
    suspend fun addNumber(params: AddNumberUseCase.Params)
}