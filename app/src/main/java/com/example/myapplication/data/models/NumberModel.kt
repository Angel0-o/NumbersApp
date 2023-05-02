package com.example.myapplication.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberModel(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,
    val number: Int
)