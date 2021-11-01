package com.example.mobiledeveloplab3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobiledeveloplab3.databinding.FramefirstBinding

class fragFirst : Fragment() {
    lateinit var binding: FramefirstBinding
    private var uuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FramefirstBinding.inflate(inflater, container, false)
        nextBtnClick()
        return binding.root
    }

    private fun nextBtnClick(){
        binding.next.setOnClickListener {
            val activityFunctions = requireActivity() as ActivityFunctions
            try {
                Calc.firstNum = binding.firstNumText.text.toString().toDouble()
            }
            catch (e: Exception){
                Calc.firstNum = null
            }
            activityFunctions.showNextFragment(uuid)
        }
    }

}