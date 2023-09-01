package com.example.pinfoapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Place(
    val latitude: String,
    val longitude: String,
    @Json(name = "place name")
    val placeName: String,
    val state: String,
    @Json(name = "state abbreviation")
    val stateAbbreviation: String
)