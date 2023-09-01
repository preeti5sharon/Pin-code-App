package com.example.pinfoapp


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PinResponse(
    val country: String,
    @Json(name = "country abbreviation")
    val countryAbbreviation: String,
    val places: List<Place>,
    @Json(name = "post code")
    val postCode: String
)