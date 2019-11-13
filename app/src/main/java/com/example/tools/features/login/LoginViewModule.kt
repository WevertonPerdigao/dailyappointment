package com.example.tools.features.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tools.di.models.jocke
import com.example.tools.di.modules.ViewModelModule
import com.example.tools.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginViewModule @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    var jockes = MutableLiveData<MutableList<jocke>>()


    init {

        loginRepository.getData().enqueue(object : Callback<MutableList<jocke>> {
            override fun onFailure(call: Call<MutableList<jocke>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<jocke>>,
                response: Response<MutableList<jocke>>
            ) {
                Log.d("lista", response.body()?.size.toString())

            }

        })
    }

}