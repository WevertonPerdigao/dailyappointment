package com.e.revisaoapp.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

import java.util.*

data class User(private var name: String, var email: String, var password: String) :
    BaseObservable() {
    var name2: String
        @Bindable get() = name
        set(value) {
            name = value
          notifyPropertyChanged(BR.name2)
        }
}