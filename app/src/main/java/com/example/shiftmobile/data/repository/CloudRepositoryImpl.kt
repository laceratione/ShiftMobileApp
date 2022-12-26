package com.example.shiftmobile.data.repository

import com.example.shiftmobile.CardInfo
import com.example.shiftmobile.data.api.RetrofitAPI
import com.example.shiftmobile.domain.repository.CloudRepository
import retrofit2.Call

//реализация облачного хранилища
class CloudRepositoryImpl(private val retrofitAPI: RetrofitAPI): CloudRepository {

    //получить данные банковской карты
    override fun getCardInfo(digits: Int): Call<CardInfo> {
        return retrofitAPI.getCardInfo(digits)
    }
}