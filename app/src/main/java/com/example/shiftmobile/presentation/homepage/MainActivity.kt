package com.example.shiftmobile.presentation.homepage

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.shiftmobile.presentation.historypage.HistoryActivity
import com.example.shiftmobile.R
import com.example.shiftmobile.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val binViewModel: BINViewModel =
            ViewModelProvider(this, BINViewModelFactory(application)).get(BINViewModel::class.java)

        binding.binViewModel = binViewModel
        binding.lifecycleOwner = this

        //открытие окон навигации
        binViewModel.botNavPageLive.observe(this, {
            when (it) {
                2 -> {
                    val intent = Intent(this, HistoryActivity::class.java)
                    startActivity(intent)
                }
            }
        })

        //запуск браузера для просмотра сайта банка
        binViewModel.linkLive.observe(this, {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://" + it)))
        })

        //запуск окна для совершения звонка
        binViewModel.phoneLive.observe(this, {
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + it)))
        })

        //запуск Google Maps
        binViewModel.coordsLive.observe(this, {
            val uri = String.format(Locale.ENGLISH, "geo:" + it)
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
        })
    }

}
