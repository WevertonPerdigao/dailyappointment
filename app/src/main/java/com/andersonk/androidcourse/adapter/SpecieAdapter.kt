package com.andersonk.androidcourse.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.models.Specie
import kotlinx.android.synthetic.main.planet_item.view.*


class SpecieAdapter() : RecyclerView.Adapter<SpecieAdapter.SpecieHolder>() {

    val species = mutableListOf<Specie>()


    fun setSpecies(species: MutableList<Specie>) {

        Log.d("species", species.toString())
        this.species.addAll(species)

        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieAdapter.SpecieHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.specie_item, parent, false)

        return SpecieHolder(view)


    }

    override fun getItemCount(): Int {
        return species.size
    }

    override fun onBindViewHolder(holder: SpecieAdapter.SpecieHolder, position: Int) {
        val specie = species[position]
        holder.setSpecie(specie)
    }


    class SpecieHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setSpecie(specie: Specie) {
            view.name.text = specie.name
        }


    }

}