package com.example.shiftmobile.di

import com.example.shiftmobile.presentation.homepage.BINViewModel
import dagger.Component

@Component(modules = [NetworkModule::class, UseCaseModule::class,
    RepositoryModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(binViewModel: BINViewModel)
}