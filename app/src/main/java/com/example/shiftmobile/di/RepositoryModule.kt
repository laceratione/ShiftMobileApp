package com.example.shiftmobile.di

import com.example.shiftmobile.data.api.RetrofitAPI
import com.example.shiftmobile.data.repository.CloudRepositoryImpl
import com.example.shiftmobile.data.repository.LocalRepositoryImpl
import com.example.shiftmobile.domain.model.AppDatabase
import com.example.shiftmobile.domain.repository.CloudRepository
import com.example.shiftmobile.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideCloudRepositoryImpl(retrofitAPI: RetrofitAPI): CloudRepository {
        return CloudRepositoryImpl(retrofitAPI)
    }

    @Provides
    fun provideLocalRepositoryImpl(database: AppDatabase): LocalRepository{
        return LocalRepositoryImpl(database)
    }
}