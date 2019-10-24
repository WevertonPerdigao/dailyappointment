package com.andersonk.androidcourse.models

data class SpecieList(
    val count: Int? = null,
    val next: String? = null,
    val previous: Any? = null,
    val results: MutableList<Specie> = mutableListOf()
)