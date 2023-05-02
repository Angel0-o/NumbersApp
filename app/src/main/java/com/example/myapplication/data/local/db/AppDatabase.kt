package com.example.myapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.local.db.dao.NumberDao
import com.example.myapplication.data.models.NumberModel

@Database(
    entities = [NumberModel::class],
    version = 1,
    exportSchema = false
)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun numberDao(): NumberDao

    companion object {
        const val DATABASE_TABLE = "number_table"
        const val DATABASE_NAME = "number_database"
    }
}