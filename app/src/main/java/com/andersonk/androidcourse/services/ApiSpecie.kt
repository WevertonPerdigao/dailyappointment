package com.andersonk.androidcourse.services

import com.andersonk.androidcourse.models.SpecieList
import retrofit2.Call
import retrofit2.http.GET

interface ApiSpecie {


    @GET("species")
    fun getEspecies(): Call<SpecieList>
}