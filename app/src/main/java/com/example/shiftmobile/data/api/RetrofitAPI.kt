package com.example.shiftmobile.data.api

import com.example.shiftmobile.CardInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//API сервера
interface RetrofitAPI {

    @GET("/{digits}")
    fun getCardInfo(@Path("digits") digits: Int): Call<CardInfo>
}