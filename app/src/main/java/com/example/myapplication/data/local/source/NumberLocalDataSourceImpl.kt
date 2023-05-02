package com.example.myapplication.data.local.source

import com.example.myapplication.data.local.db.dao.NumberDao
import com.example.myapplication.data.models.NumberModel
import com.example.myapplication.data.repositories.NumberLocalDataSource
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class NumberLocalDataSourceImpl @Inject constructor(
    private val dao: NumberDao
) : NumberLocalDataSource {
    override suspend fun addNumber(params: AddNumberUseCase.Params) {
        val body = NumberModel(
            number = params.number
        )
        dao.addNumber(body)
    }

    override fun getNumbersOrderByRepetitions(): Flow<List<NumberModel>> {
        return dao.getNumbersOrderByRepetitions()
    }
}