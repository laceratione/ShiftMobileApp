package com.example.shiftmobile

import android.app.Application
import com.example.shiftmobile.di.AppComponent
import com.example.shiftmobile.di.DaggerAppComponent
import com.example.shiftmobile.di.DatabaseModule

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .databaseModule(DatabaseModule(this))
            .build()
    }
}