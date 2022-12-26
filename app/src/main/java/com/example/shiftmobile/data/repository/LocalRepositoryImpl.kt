package com.example.shiftmobile.data.repository

import com.example.shiftmobile.domain.model.AppDatabase
import com.example.shiftmobile.domain.model.HistoryDao
import com.example.shiftmobile.domain.model.HistoryEntity
import com.example.shiftmobile.domain.repository.LocalRepository

//реализация локального хранилища
class LocalRepositoryImpl(private val database: AppDatabase): LocalRepository {

    //добавить запрос
    override fun addHistory(historyEntity: HistoryEntity) {
        val historyDao: HistoryDao = database.historyDao()
        historyDao.insertBIN(historyEntity)
    }

    //вернуть список запросов
    override fun getAllHistory(): List<HistoryEntity> {
        val historyDao: HistoryDao = database.historyDao()
        val history: List<HistoryEntity> = historyDao.getAll()
        return history
    }

    //очистить историю запросов
    override fun clearAllHistory(){
        database.historyDao().clearAll()
    }

}