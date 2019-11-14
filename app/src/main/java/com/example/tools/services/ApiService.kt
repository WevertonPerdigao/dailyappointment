package com.example.tools.services

import com.example.tools.di.models.joke
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/random_ten")
    fun get(): Call<MutableList<joke>>
}