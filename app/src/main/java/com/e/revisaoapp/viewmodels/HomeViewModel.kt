package com.e.revisaoapp.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.e.revisaoapp.models.User

class HomeViewModel : ViewModel() {

    var usuario = ObservableField<User>()


}