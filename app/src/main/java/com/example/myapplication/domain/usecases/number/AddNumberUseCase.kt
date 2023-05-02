package com.example.myapplication.domain.usecases.number

import com.example.myapplication.domain.repositories.NumberRepository
import com.example.myapplication.domain.usecases.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class AddNumberUseCase @Inject constructor(
    private val repository: NumberRepository,
    background: CoroutineDispatcher
) : UseCase<Unit, AddNumberUseCase.Params>(background) {

    override suspend fun run(input: Params?) {
        requireNotNull(input) { "The number can't be null" }
        return repository.addNumber(params = input)
    }

    data class Params(
        val number: Int
    )
}