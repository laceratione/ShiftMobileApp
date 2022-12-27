package com.example.shiftmobile.presentation.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.shiftmobile.R
import com.example.shiftmobile.databinding.FragmentBinBinding

class BINFragment: Fragment() {
    private val sharedViewModel: BINViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentBinBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bin, container, false)
        binding.apply {
            binViewModel = sharedViewModel
        }
        binding.setLifecycleOwner(this)

        return binding.root
    }

    companion object {
        fun newInstance() = BINFragment()
    }

}