package com.e.revisaoapp.viewmodels

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.e.revisaoapp.models.User

class HomeViewModel : ViewModel() {

    var usuario = ObservableField<User>()


    fun afterChanged(s: Editable) {
        Log.d("afterChanged", "chamando afterChanged" + s)

    }

    fun beforeChanged(s: CharSequence, star: Int, count: Int, after: Int) {
        Log.d("beforeChanged", "chamando beforeChanged" + s)
    }

    fun onChanged(s: CharSequence, star: Int, before: Int, count: Int) {
        Log.d("onChanged", "chamando onChanged" + s)
    }

    fun buttonClick(view: View?) {
        Log.d("buttonClick", "chamando buttonClick" + view)
    }


}