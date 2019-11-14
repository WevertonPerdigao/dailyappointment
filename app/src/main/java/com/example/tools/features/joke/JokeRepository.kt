package com.example.tools.features.joke

import com.example.tools.di.models.joke
import com.example.tools.services.ApiService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JokeRepository @Inject constructor(private val apiService: ApiService) {

    fun getData(): Call<MutableList<joke>> {
        return apiService.get()
    }
}