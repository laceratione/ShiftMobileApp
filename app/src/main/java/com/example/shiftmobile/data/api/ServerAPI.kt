package com.example.shiftmobile.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Retrofit-клиент
object ServerAPI {
    private var retrofit: Retrofit? = null
    private val baseURL: String = "https://lookup.binlist.net"

    fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}