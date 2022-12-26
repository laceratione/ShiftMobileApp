package com.example.shiftmobile.di

import com.example.shiftmobile.domain.repository.CloudRepository
import com.example.shiftmobile.domain.usecase.GetCardInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetCardInfoUseCase(cloudRepository: CloudRepository): GetCardInfoUseCase{
        return GetCardInfoUseCase(cloudRepository)
    }
}