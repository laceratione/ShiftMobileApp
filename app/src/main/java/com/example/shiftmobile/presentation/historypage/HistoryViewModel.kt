package com.example.shiftmobile.presentation.historypage

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftmobile.App
import com.example.shiftmobile.domain.model.HistoryEntity
import com.example.shiftmobile.domain.repository.LocalRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class HistoryViewModel(application: Application) : ViewModel() {
    @Inject
    lateinit var localRepository: LocalRepository

    //история запросов
    private val data: MutableLiveData<List<HistoryEntity>> = MutableLiveData()
    val dataLive: LiveData<List<HistoryEntity>> = data

    init {
        (application as App).appComponent.inject(this)

        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            getHistory()
        }
        job.start()
    }

    fun startJob() {
        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            clearAllHistory()
        }
        job.start()
    }

    //очистить историю запросов
    suspend fun clearAllHistory() = coroutineScope {
        launch {
            localRepository.clearAllHistory()
            data.postValue(emptyList())
        }
    }

    //получить историю запросов
    suspend fun getHistory() = coroutineScope {
        launch {
            data.postValue(localRepository.getAllHistory())
        }
    }

}