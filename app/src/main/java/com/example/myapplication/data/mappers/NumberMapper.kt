package com.example.myapplication.data.mappers

import com.example.myapplication.data.models.NumberModel
import com.example.myapplication.domain.entities.NumberEntity

internal fun NumberModel.toEntity() = NumberEntity(
    id = uid,
    number = number
)

internal fun List<NumberModel>.toListEntity() = map { it.toEntity() }