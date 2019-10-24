package com.andersonk.androidcourse.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties


@JsonIgnoreProperties(ignoreUnknown = true)
data class Question(
    val answer_count: Int? = null,
    val creation_date: Int? = null,
    val is_answered: Boolean? = null,
    val last_activity_date: Int? = null,
    val link: String? = null,
    val owner: Owner? = null,
    val question_id: Int? = null,
    val score: Int? = null,
    val tags: List<String>? = null,
    val title: String? = null,
    val view_count: Int? = null
)