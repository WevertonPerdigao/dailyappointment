package com.example.tools.features.joke

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tools.di.models.joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class JokeViewModule @Inject constructor(private val jokeRepository: JokeRepository) :
    ViewModel() {

    var jockes = MutableLiveData<MutableList<joke>>()


    init {

        jokeRepository.getData().enqueue(object : Callback<MutableList<joke>> {
            override fun onFailure(call: Call<MutableList<joke>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<joke>>,
                response: Response<MutableList<joke>>
            ) {
                Log.d("lista", response.body()?.size.toString())

                response.body().let {
                    jockes.postValue(it)
                }

            }

        })
    }

}