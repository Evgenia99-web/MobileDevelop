package com.example.mobiledeveloplab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledeveloplab3.databinding.FramesecondBinding

class fragSecond : Fragment() {
    lateinit var binding: FramesecondBinding
    private var uuid = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FramesecondBinding.inflate(inflater, container, false)
        nextBtnClick()
        backBtnClick()
        return binding.root
    }

    private fun nextBtnClick(){
        binding.next.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            try {
                Calc.secondNum = binding.secondNumText.text.toString().toDouble()
            }
            catch (e: Exception){
                Calc.secondNum = null
            }
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