package com.example.mobiledeveloplab4

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import java.util.concurrent.TimeUnit

class AsyncFrag : Fragment() {
    companion object{const val tag = "Async"}

    var actors = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        ActorsList.addListener(actorsListener)
        Log.i("[APP]", "Starting Async")
        MessageSend().execute()
    }

    private val actorsListener: ActorListener = {
        if (it != null){
            actors.add(it)
            val callback = requireActivity() as ActivityCallback
            callback.getNextActor(it)
        }
    }

    class MessageSend : AsyncTask<Void, Void, Void>(){

        override fun onProgressUpdate(vararg v0: Void?) {
            super.onProgressUpdate()
            ActorsList.sendMess()
        }

        override fun doInBackground(vararg v0: Void?): Void? {
            for (i in 1..ActorsList.actorList.count()){
                TimeUnit.SECONDS.sleep(2)
                publishProgress()
            }
            return null
        }
    }
}