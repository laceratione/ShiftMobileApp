package com.example.shiftmobile.di

import com.example.shiftmobile.data.api.RetrofitAPI
import com.example.shiftmobile.data.api.ServerAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitAPI(): RetrofitAPI {
        return ServerAPI.getInstance().create(RetrofitAPI::class.java)
    }
}