package com.testeapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Todo(var id: Int?, var description: String?, var status: Boolean=false) : Parcelable