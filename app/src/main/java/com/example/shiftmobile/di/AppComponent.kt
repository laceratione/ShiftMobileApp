package com.example.shiftmobile.di

import com.example.shiftmobile.presentation.homepage.BINViewModel
import com.example.shiftmobile.presentation.historypage.HistoryActivity
import com.example.shiftmobile.presentation.historypage.HistoryViewModel
import dagger.Component

@Component(modules = [NetworkModule::class, UseCaseModule::class,
    RepositoryModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(binViewModel: BINViewModel)
    fun inject(historyViewModel: HistoryViewModel)
}