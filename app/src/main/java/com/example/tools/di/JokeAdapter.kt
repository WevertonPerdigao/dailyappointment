package com.example.tools.di

import com.example.tools.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tools.di.models.joke
import kotlinx.android.synthetic.main.joke_item.view.*

class JokeAdapter() : RecyclerView.Adapter<JokeAdapter.JokeHolder>() {

    val jokes = mutableListOf<joke>()


//    fun bindData(question:Question){
//        view.owner_img.load
//    }


    fun setJokes(jokes: MutableList<joke>) {
        this.jokes.addAll(jokes)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.joke_item, parent, false)
        return JokeHolder(view)

    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokeHolder, position: Int) {
        val joke = jokes[position]
        holder.setJoke(joke)
    }

    class JokeHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setJoke(joke: joke) {
            view.name.text = joke.punchline
        }


    }

}
