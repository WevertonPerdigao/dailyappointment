package com.andersonk.androidcourse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.adapter.PlanetAdapter
import com.andersonk.androidcourse.models.PlanetList
import com.andersonk.androidcourse.services.Api
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_planet.*
import kotlinx.android.synthetic.main.content_planet.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class PlanetActivity : AppCompatActivity() {

    lateinit var planetAdapter: PlanetAdapter
    val INDENTTIFY_REQUEST = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)

        planetAdapter = PlanetAdapter()


        val layoutManager = LinearLayoutManager(this)

        recycler_planets.layoutManager = layoutManager
        recycler_planets.adapter = planetAdapter

        getData()
        this.listenerBtnFab()


    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(JacksonConverterFactory.create()).build()
        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getPlanets()
        //lista de requisicoes ficam na fila  todas chamadas sao encadeadas
        call.enqueue(object : Callback<PlanetList> {
            override fun onFailure(call: Call<PlanetList>, t: Throwable) {
                Log.d("Error", t.toString())

            }

            override fun onResponse(call: Call<PlanetList>, response: Response<PlanetList>) {
                when (response.code()) {
                    200 -> {
                        val body = response.body()
                        body?.let {
                            planetAdapter.setPlanets(it.results)
                        }
                        Log.d("NETWORK", response.body().toString())
                    }
                    204 -> Log.d("NETWORK", "Not content")

                }
            }

        })


    }

    private fun listenerBtnFab() {

        fab2.setOnClickListener({
            val intent = Intent(applicationContext, SpecieActivity::class.java)
            startActivityForResult(intent, INDENTTIFY_REQUEST)
        })


    }

}
