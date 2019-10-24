package com.andersonk.androidcourse.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.models.Planet
import kotlinx.android.synthetic.main.planet_item.view.*

class PlanetAdapter() : RecyclerView.Adapter<PlanetAdapter.PlanetHolder>() {

    val planets = mutableListOf<Planet>()

    fun setPlanets(planets: MutableList<Planet>) {
        Log.d("planets", planets.toString())
        this.planets.addAll(planets)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetHolder {

        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.planet_item, parent, false)
        return PlanetHolder(view)

    }

    override fun getItemCount(): Int {
        return planets.size
    }

    override fun onBindViewHolder(holder: PlanetHolder, position: Int) {
        val planet = planets[position]
        holder.setPlanet(planet)
    }

    class PlanetHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun setPlanet(planet: Planet) {

            view.name.text = planet.name

        }

    }


}