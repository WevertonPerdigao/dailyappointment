package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Owner(
    val display_name: String? = null,
    val link: String? = null,
    val profile_image: String? = null,
    val reputation: Int? = null,
    val user_id: Int? = null,
    val user_type: String? = null
)