package com.example.shiftmobile.presentation.homepage

import android.app.Application
import android.util.Log
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shiftmobile.App
import com.example.shiftmobile.CardInfo
import com.example.shiftmobile.R
import com.example.shiftmobile.domain.model.HistoryEntity
import com.example.shiftmobile.domain.repository.LocalRepository
import com.example.shiftmobile.domain.usecase.GetCardInfoUseCase
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BINViewModel(application: Application): ViewModel() {
    //данные банковской карты
    private val cardInfo: MutableLiveData<CardInfo> = MutableLiveData()
    val cardInfoLive: LiveData<CardInfo> = cardInfo

    //текущая страница навигации
    private val botNavPage: MutableLiveData<Int> = MutableLiveData()
    val botNavPageLive: LiveData<Int> = botNavPage

    //web-ссылка сайта банка
    private val link: MutableLiveData<String> = MutableLiveData()
    val linkLive: LiveData<String> = link

    //номер телефона банка
    private val phone: MutableLiveData<String> = MutableLiveData()
    val phoneLive: LiveData<String> = phone

    //координаты страны
    private val coords: MutableLiveData<String> = MutableLiveData()
    val coordsLive: LiveData<String> = coords

    //BIN банковской карты
    val bin: MutableLiveData<String> = MutableLiveData()

    //проверка процесса загрузки данных
    val isCardInfoLoading: MutableLiveData<Boolean> = MutableLiveData()

    @Inject
    lateinit var cardInfoUseCase: GetCardInfoUseCase

    @Inject
    lateinit var localRepository: LocalRepository

    init {
        (application as App).appComponent.inject(this)
    }

    fun startJob(){
        val jobGetCardInfo: Job = GlobalScope.launch(Dispatchers.IO) {
            getCardInfo()
        }
        jobGetCardInfo.start()
    }

    //получение данных карты
    suspend fun getCardInfo() = coroutineScope{
        launch {
            isCardInfoLoading.postValue(true)

            bin.value?.toInt().let {
                cardInfoUseCase(it!!).enqueue(object : Callback<CardInfo>{
                    override fun onResponse(call: Call<CardInfo>, response: Response<CardInfo>) {
                        cardInfo.postValue(response.body())
                        isCardInfoLoading.postValue(false)
                    }

                    override fun onFailure(call: Call<CardInfo>, t: Throwable) {
                        Log.d("myLogs", t.message.toString())
                    }

                })

                //запись истории запроса в БД
                val historyEntity = HistoryEntity(0, it.toString())
                localRepository.addHistory(historyEntity)
            }
        }
    }

    //определение текущей страницы навигации
    fun bottomNavItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.page_2 -> botNavPage.value = 2

        }
        return true
    }

    //обработка нажатия на ссылку
    fun linkClicked(){
        link.value = cardInfo.value?.bank?.url
    }

    //обработка нажатия на номер телефона
    fun phoneClicked(){
        phone.value = cardInfo.value?.bank?.phone
    }

    //обработка нажатия на координаты страны
    fun coordsClicked(){
        coords.value = cardInfo.value?.country?.latitude.toString() +
                "," + cardInfo.value?.country?.longitude.toString()
    }
}