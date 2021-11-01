package com.example.mobiledeveloplab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledeveloplab3.databinding.FramethirdBinding

class fragThird : Fragment() {
    lateinit var binding: FramethirdBinding
    private var uuid = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FramethirdBinding.inflate(inflater, container, false)
        nextBtnClick()
        backBtnClick()
        return binding.root
    }

    private fun nextBtnClick(){
        binding.next.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            Calc.mathOperation = binding.mathOperationText.text.toString()
            activityFunctions.showNextFragment(uuid)
        }
    }

    private fun backBtnClick(){
        binding.back.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            activityFunctions.showPreviousFragment(uuid)
        }
    }

}