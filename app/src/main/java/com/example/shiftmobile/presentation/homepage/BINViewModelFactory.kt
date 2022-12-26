package com.example.shiftmobile.presentation.homepage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BINViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BINViewModel::class.java)) {
            return BINViewModel(application) as T
        }
        throw IllegalArgumentException("Class not found")
    }
}