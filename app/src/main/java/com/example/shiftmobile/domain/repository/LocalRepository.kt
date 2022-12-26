package com.example.shiftmobile.domain.repository

import com.example.shiftmobile.domain.model.HistoryEntity

interface LocalRepository {
    fun addHistory(historyEntity: HistoryEntity)
    fun getAllHistory(): List<HistoryEntity>
    fun clearAllHistory()
}