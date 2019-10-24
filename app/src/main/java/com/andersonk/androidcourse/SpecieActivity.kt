package com.andersonk.androidcourse

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.adapter.SpecieAdapter
import com.andersonk.androidcourse.models.Specie
import com.andersonk.androidcourse.models.SpecieList
import com.andersonk.androidcourse.services.ApiSpecie

import kotlinx.android.synthetic.main.activity_specie.*
import kotlinx.android.synthetic.main.content_specie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class SpecieActivity : AppCompatActivity() {

    lateinit var specieAdapter: SpecieAdapter
    val INDENTIFY_REQUEST = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specie)


        specieAdapter = SpecieAdapter()

        val layoutManager = LinearLayoutManager(this)

        recycler_species.layoutManager = layoutManager
        recycler_species.adapter = specieAdapter

        getData()


    }

    private fun getData() {
        val retrofit = Retrofit.Builder().baseUrl("https://swapi.co/api/")
            .addConverterFactory(JacksonConverterFactory.create()).build()

        val service = retrofit.create<ApiSpecie>(ApiSpecie::class.java)
        val call = service.getEspecies()

        call.enqueue(object : Callback<SpecieList> {
            override fun onFailure(call: Call<SpecieList>, t: Throwable) {
                Log.d("Error", t.toString())
            }

            override fun onResponse(call: Call<SpecieList>, response: Response<SpecieList>) {
                when (response.code()) {
                    200 -> {
                        val body = response.body()
                        body?.let {
                            specieAdapter.setSpecies(it.results)
                        }
                        Log.d("NETWORK", response.body().toString())
                    }
                    204 -> Log.d("NETWORK", "Not content")

                }
            }

        })
    }

}
