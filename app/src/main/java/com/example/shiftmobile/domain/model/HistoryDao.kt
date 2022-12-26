package com.example.shiftmobile.domain.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert
    fun insertBIN(bin: HistoryEntity)

    @Delete
    fun deleteBIN(bin: HistoryEntity)

    @Query("select * from history_table")
    fun getAll(): List<HistoryEntity>

    @Query("delete from history_table")
    fun clearAll()
}