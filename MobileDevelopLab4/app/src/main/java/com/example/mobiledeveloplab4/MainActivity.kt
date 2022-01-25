package com.example.mobiledeveloplab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobiledeveloplab4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

interface ActivityCallback{
    fun getNextActor(person: Person)
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapt: ActorsAdapt
    private var frag: AsyncFrag? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var fragManager = supportFragmentManager
        var oldFrag = fragManager.findFragmentByTag(AsyncFrag.tag)
        if (oldFrag == null){
            frag = AsyncFrag()
            Log.i("APP","Creating fragment")
            fragManager.beginTransaction().add(frag!!, AsyncFrag.tag).commit()
        }
        else{
            frag = oldFrag as AsyncFrag
            Log.i("[APP]", "Find fragment and got last messages")
            adapt.getLastActors(frag!!.actors)
        }

        adapt = ActorsAdapt(object: ActorsListenerClick{
            override fun clickCard(name: String) {
                Snackbar.make(binding.root, "Просмотр карточки: ${name}", 600).show()
            }

            override fun clickCardLike(name: String) {
                Snackbar.make(binding.root, "Поставили лайк: ${name}", 600).show()
            }
        })


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapt
    }

    override fun getNextActor(person: Person){
        adapt.addNextActor(person)
    }
}