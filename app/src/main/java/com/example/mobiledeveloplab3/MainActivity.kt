package com.example.mobiledeveloplab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.mobiledeveloplab3.databinding.ActivityMainBinding


interface ActivityFunctions{
    fun showNextFragment(uuid: Int)
    fun showPreviousFragment(uuid: Int)
}

class MainActivity : AppCompatActivity(), ActivityFunctions{
    lateinit var binding: ActivityMainBinding
    var fragmentList: List<Fragment> = listOf(fragFirst(), fragSecond(), fragThird(), fragForth())
    var buttonList: MutableList<Button> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonList.add(0, binding.button1)
        buttonList.add(1, binding.button2)
        buttonList.add(2, binding.button3)
        buttonList.add(3, binding.button4)

        setClickListenerBtn()
    }

    private fun setClickListenerBtn(){
        if (fragmentList.size != buttonList.size) return
        for (i in fragmentList.indices){
            if ( i != 0 ) buttonList[i].setEnabled(false)
            buttonList[i].setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.containerFrame, fragmentList[i]).commit()
            }
        }
    }

    override fun showNextFragment(uuid: Int){
        supportFragmentManager.beginTransaction().replace(R.id.containerFrame, fragmentList[uuid + 1]).commit()
        activeButtons(uuid + 1)
    }

    override fun showPreviousFragment(uuid: Int) {
        supportFragmentManager.beginTransaction().replace(R.id.containerFrame, fragmentList[uuid - 1]).commit()
    }

    fun activeButtons(uuid: Int){
        for (i in 0..uuid) {
            buttonList[i].setEnabled(true)
        }
    }
}