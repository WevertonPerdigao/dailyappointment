package com.example.tools.features.login

import android.util.Log
import com.example.tools.di.models.jocke
import com.example.tools.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(private val apiService: ApiService) {

    fun getData(): Call<MutableList<jocke>> {
        return apiService.get()
    }
}