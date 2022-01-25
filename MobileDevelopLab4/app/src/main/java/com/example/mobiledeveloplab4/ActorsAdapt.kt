package com.example.mobiledeveloplab4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiledeveloplab4.databinding.ListItemBinding

interface ActorsListenerClick{
    fun clickCard(name: String)
    fun clickCardLike(name: String)
}

class ActorsAdapt(private val clickListener: ActorsListenerClick) :
    RecyclerView.Adapter<ActorsAdapt.ActorsView>() {

    private val actors = mutableListOf<Person>()

    fun addNextActor(nextPerson: Person){
        actors.add(nextPerson)
        notifyDataSetChanged()
    }

    fun getLastActors(lastPersons: MutableList<Person>){
        for (nextPerson in lastPersons)
          actors.add(nextPerson)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsView {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ActorsView(binding)
    }

    override fun onBindViewHolder(list: ActorsView, position: Int) {
        val person = actors[position]
        list.bind(person,clickListener)
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    class ActorsView(var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Person, clickListener: ActorsListenerClick){
            itemView.setOnClickListener {
                clickListener.clickCard(person.name)
            }
            binding.run {
                like.setOnClickListener{
                    clickListener.clickCardLike(person.name)
                }
                name.text = person.name
                sex.text = person.sex
                date.text = person.date
                text.text = person.text
            }
        }
    }

}