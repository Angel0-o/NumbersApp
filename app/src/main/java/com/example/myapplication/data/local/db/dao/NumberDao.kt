package com.example.myapplication.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.models.NumberModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Query("Select * from NumberModel order by number")
    fun getNumbersOrderByRepetitions(): Flow<List<NumberModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNumber(numberModel: NumberModel)
}