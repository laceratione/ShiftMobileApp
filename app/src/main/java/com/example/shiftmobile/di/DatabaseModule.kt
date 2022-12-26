package com.example.shiftmobile.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.shiftmobile.domain.model.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(private val contex: Context) {

    @Provides
    fun provideDatabase(): AppDatabase {
        return Room.databaseBuilder(contex, AppDatabase::class.java, "database")
            .build()
    }
}