package com.example.myapplication.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.models.NumberModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Query("SELECT t1.uid, t1.number, t2.count\n" +
            "FROM NumberModel t1\n" +
            "JOIN (\n" +
            "   SELECT number, COUNT(*) AS count \n" +
            "   FROM NumberModel \n" +
            "   GROUP BY number \n" +
            ") t2 ON t1.number = t2.number\n" +
            "ORDER BY t2.count DESC, t1.number")
    fun getNumbersOrderByRepetitions(): Flow<List<NumberModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNumber(numberModel: NumberModel)
}