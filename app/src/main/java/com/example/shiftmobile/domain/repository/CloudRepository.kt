package com.example.shiftmobile.domain.repository

import com.example.shiftmobile.CardInfo
import retrofit2.Call

interface CloudRepository {
    fun getCardInfo(digits: Int): Call<CardInfo>
}