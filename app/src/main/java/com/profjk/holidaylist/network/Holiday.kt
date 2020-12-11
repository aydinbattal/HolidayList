package com.profjk.holidaylist.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/*
User jigishapatel
Student ID M05038
Name Jigisha Patel
Date 2020-12-08
*/
@JsonClass(generateAdapter = true)
data class Holiday(
    @Json(name = "name") val name: String? = null,
    @Json(name = "date") val date: String? = null
)