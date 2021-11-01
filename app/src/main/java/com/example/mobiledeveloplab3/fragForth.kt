package com.example.mobiledeveloplab3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledeveloplab3.databinding.FrameforthBinding

class fragForth : Fragment() {
    lateinit var binding: FrameforthBinding
    private var uuid = 3

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrameforthBinding.inflate(inflater, container, false)
        binding.result.text = Calc.firstNum.toString() + " "+ Calc.mathOperation + " " + Calc.secondNum.toString() +" = " + Calc.calc().toString()
        backBtnClick()
        return binding.root
    }

    private fun backBtnClick(){
        binding.back.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            activityFunctions.showPreviousFragment(uuid)
        }
    }

}