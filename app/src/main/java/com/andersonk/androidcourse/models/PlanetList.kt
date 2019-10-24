package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class PlanetList(
    val count: Int? = null,
    val next: String? = null,
    val previous: Any? = null,
    val results: MutableList<Planet> = mutableListOf()
)