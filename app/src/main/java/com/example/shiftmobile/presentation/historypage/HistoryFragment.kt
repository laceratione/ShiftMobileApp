package com.example.shiftmobile.presentation.historypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.shiftmobile.R
import com.example.shiftmobile.databinding.FragmentHistoryBinding
import com.example.shiftmobile.presentation.homepage.BINViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {
    private val sharedViewModel: BINViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHistoryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history, container, false)
        binding.apply {
            binViewModel = sharedViewModel
        }
        binding.setLifecycleOwner(this)

        return binding.root
    }

    companion object {
        fun newInstance() = HistoryFragment()
    }

    override fun onStart() {
        super.onStart()

        //при открытии фрагмента загружаем историю запросов
        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            sharedViewModel.getHistory()
        }
        job.start()
    }
}