package com.example.shiftmobile.presentation.historypage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shiftmobile.R
import com.example.shiftmobile.databinding.ActivityHistoryBinding

//окно истории запросов пользователя
class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val binding: ActivityHistoryBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_history)
        val historyViewModel: HistoryViewModel =
            ViewModelProvider(this, HistoryViewModelFactory(application)).get(HistoryViewModel::class.java)

        binding.historyViewModel = historyViewModel
        binding.lifecycleOwner = this
    }

}