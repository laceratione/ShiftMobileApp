package com.example.shiftmobile.domain.usecase

import com.example.shiftmobile.CardInfo
import com.example.shiftmobile.domain.repository.CloudRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class GetCardInfoUseCase(
    private val cloudRepository: CloudRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(digits: Int): Call<CardInfo> = withContext(defaultDispatcher) {
        val cardInfo = cloudRepository.getCardInfo(digits)
        cardInfo
    }
}